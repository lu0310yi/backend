package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class Message implements Serializable {
    private Long subjectId;

    private Long objectId;

    private String status;

    private String type;

    private Date gmtTime;

    private Long namecardId;

    private Integer duration;

    private Integer size;

    private String fileName;

    private String fileType;

    private String locationName;

    private String locationDetail;

    private Double locationLat;

    private Double locationLng;

    private String content;

    private static final long serialVersionUID = 1L;

    public Message(Long subjectId, Long objectId, String status, String type, Date gmtTime, Long namecardId, Integer duration, Integer size, String fileName, String fileType, String locationName, String locationDetail, Double locationLat, Double locationLng, String content) {
        this.subjectId = subjectId;
        this.objectId = objectId;
        this.status = status;
        this.type = type;
        this.gmtTime = gmtTime;
        this.namecardId = namecardId;
        this.duration = duration;
        this.size = size;
        this.fileName = fileName;
        this.fileType = fileType;
        this.locationName = locationName;
        this.locationDetail = locationDetail;
        this.locationLat = locationLat;
        this.locationLng = locationLng;
        this.content = content;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public Date getGmtTime() {
        return gmtTime;
    }

    public Long getNamecardId() {
        return namecardId;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getSize() {
        return size;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationDetail() {
        return locationDetail;
    }

    public Double getLocationLat() {
        return locationLat;
    }

    public Double getLocationLng() {
        return locationLng;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subjectId=").append(subjectId);
        sb.append(", objectId=").append(objectId);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", gmtTime=").append(gmtTime);
        sb.append(", namecardId=").append(namecardId);
        sb.append(", duration=").append(duration);
        sb.append(", size=").append(size);
        sb.append(", fileName=").append(fileName);
        sb.append(", fileType=").append(fileType);
        sb.append(", locationName=").append(locationName);
        sb.append(", locationDetail=").append(locationDetail);
        sb.append(", locationLat=").append(locationLat);
        sb.append(", locationLng=").append(locationLng);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}