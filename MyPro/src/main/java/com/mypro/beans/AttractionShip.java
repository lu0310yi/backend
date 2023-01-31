package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class AttractionShip implements Serializable {
    private Long userId;

    private Long attractionId;

    private String status;

    private static final long serialVersionUID = 1L;

    public AttractionShip(Long userId, Long attractionId, String status) {
        this.userId = userId;
        this.attractionId = attractionId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAttractionId() {
        return attractionId;
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
        sb.append(", userId=").append(userId);
        sb.append(", attractionId=").append(attractionId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}