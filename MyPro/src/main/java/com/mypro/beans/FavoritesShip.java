package com.mypro.beans;

import java.io.Serializable;
import java.util.Date;

public class FavoritesShip implements Serializable {
    private Long userId;

    private Long favoritesId;

    private String type;

    private Date gmtOperation;

    private static final long serialVersionUID = 1L;

    public FavoritesShip(Long userId, Long favoritesId, String type, Date gmtOperation) {
        this.userId = userId;
        this.favoritesId = favoritesId;
        this.type = type;
        this.gmtOperation = gmtOperation;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFavoritesId() {
        return favoritesId;
    }

    public String getType() {
        return type;
    }

    public Date getGmtOperation() {
        return gmtOperation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", favoritesId=").append(favoritesId);
        sb.append(", type=").append(type);
        sb.append(", gmtOperation=").append(gmtOperation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}