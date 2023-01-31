package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class Location implements Serializable {
    private Long userId;

    private Double latitude;

    private Double longtitude;

    private Byte online;

    private static final long serialVersionUID = 1L;

    public Location(Long userId, Double latitude, Double longtitude, Byte online) {
        this.userId = userId;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.online = online;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public Byte getOnline() {
        return online;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", latitude=").append(latitude);
        sb.append(", longtitude=").append(longtitude);
        sb.append(", online=").append(online);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}