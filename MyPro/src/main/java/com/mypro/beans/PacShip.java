package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class PacShip implements Serializable {
    private Long userId;

    private Long pacId;

    private String type;

    private Long favoritesId;

    private Date gmtOperation;

    private String pacType;

    private static final long serialVersionUID = 1L;

    public PacShip(Long userId, Long pacId, String type, Long favoritesId, Date gmtOperation, String pacType) {
        this.userId = userId;
        this.pacId = pacId;
        this.type = type;
        this.favoritesId = favoritesId;
        this.gmtOperation = gmtOperation;
        this.pacType = pacType;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPacId() {
        return pacId;
    }

    public String getType() {
        return type;
    }

    public Long getFavoritesId() {
        return favoritesId;
    }

    public Date getGmtOperation() {
        return gmtOperation;
    }

    public String getPacType() {
        return pacType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", pacId=").append(pacId);
        sb.append(", type=").append(type);
        sb.append(", favoritesId=").append(favoritesId);
        sb.append(", gmtOperation=").append(gmtOperation);
        sb.append(", pacType=").append(pacType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}