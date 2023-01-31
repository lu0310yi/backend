package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class Files implements Serializable {
    private Integer fileId;

    private String fileName;

    private String type;

    private Long size;

    private String md5;

    private String url;

    private String isDelete;

    private String enable;

    private static final long serialVersionUID = 1L;

    public Files(Integer fileId, String fileName, String type, Long size, String md5, String url, String isDelete, String enable) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.type = type;
        this.size = size;
        this.md5 = md5;
        this.url = url;
        this.isDelete = isDelete;
        this.enable = enable;
    }

    public Integer getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getType() {
        return type;
    }

    public Long getSize() {
        return size;
    }

    public String getMd5() {
        return md5;
    }

    public String getUrl() {
        return url;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public String getEnable() {
        return enable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileId=").append(fileId);
        sb.append(", fileName=").append(fileName);
        sb.append(", type=").append(type);
        sb.append(", size=").append(size);
        sb.append(", md5=").append(md5);
        sb.append(", url=").append(url);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", enable=").append(enable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}