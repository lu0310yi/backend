package com.mypro.controller;

import cn.hutool.core.io.FileUtil;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.mypro.beans.Files;
import com.mypro.beans.FilesExample;
import com.mypro.mapper.FilesMapper;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Autowired
    FilesMapper filesMapper;

    /**
     * 文件上传接口
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestBody MultipartFile file) throws IOException {
        System.out.println(file);
        String name = file.getOriginalFilename();
        String type = FileUtil.extName(name);
        Long size = file.getSize();
        File upLoadParentFile = new File(fileUploadPath);
        if(!upLoadParentFile.exists()){
            upLoadParentFile.mkdir();
        }
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid+ StrUtil.DOT+type;
        File uploadFile = new File(fileUploadPath+fileUUID);
        file.transferTo(uploadFile);


        String url=new String();
        String md5 = SecureUtil.md5(uploadFile);

        Files files = getFilesByMD5(md5);
        if(files==null) {
            url = "http://localhost:8081/file/"+fileUUID;
        }else{
            url = files.getUrl();
            uploadFile.delete();
        }

        Files saveFile = new Files();
        saveFile.setFileName(name);
        saveFile.setType(type);
        saveFile.setSize(size);
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        filesMapper.insert(saveFile);
        return url;
    }

    @GetMapping("/{fileUUID}")
    public void download(@PathVariable("fileUUID")String fileUUID, HttpServletResponse response) throws IOException {
        File file = new File(fileUploadPath+ fileUUID) ;
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileUUID,"UTF-8"));
        response.setContentType("application/octet-stream");

        os.write(FileUtil.readBytes(file));
        os.flush();
        os.close();
    }
    public Files getFilesByMD5(String md5){
        FilesExample filesExample = new FilesExample();
        filesExample.createCriteria().andMd5EqualTo(md5);
        List<Files> filesList = (List<Files>) filesMapper.selectByExample(filesExample);
        if(filesList.size()>0){
            return filesList.get(0);
        }else{
            return null;
        }
    }
}
