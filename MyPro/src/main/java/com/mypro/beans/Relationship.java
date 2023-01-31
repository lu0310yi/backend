package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class Relationship implements Serializable {
    private Long subjectId;

    private Long objectId;

    private String status;

    private static final long serialVersionUID = 1L;

    public Relationship(Long subjectId, Long objectId, String status) {
        this.subjectId = subjectId;
        this.objectId = objectId;
        this.status = status;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subjectId=").append(subjectId);
        sb.append(", objectId=").append(objectId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}