package com.mypro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data

@NoArgsConstructor
public class Setting implements Serializable {
    private Long userId;

    private Byte followVisible;

    private Byte fansVisible;

    private Byte visitedVisible;

    private Byte wantVisible;

    private Byte locationVisible;

    private Byte thumbupVisible;

    private Byte favoritesVisible;

    private Byte defaultFavoritesPublic;

    private static final long serialVersionUID = 1L;

    public Setting(Long userId, Byte followVisible, Byte fansVisible, Byte visitedVisible, Byte wantVisible, Byte locationVisible, Byte thumbupVisible, Byte favoritesVisible, Byte defaultFavoritesPublic) {
        this.userId = userId;
        this.followVisible = followVisible;
        this.fansVisible = fansVisible;
        this.visitedVisible = visitedVisible;
        this.wantVisible = wantVisible;
        this.locationVisible = locationVisible;
        this.thumbupVisible = thumbupVisible;
        this.favoritesVisible = favoritesVisible;
        this.defaultFavoritesPublic = defaultFavoritesPublic;
    }
    public Setting( Byte followVisible, Byte fansVisible, Byte visitedVisible, Byte wantVisible, Byte locationVisible, Byte thumbupVisible, Byte favoritesVisible, Byte defaultFavoritesPublic) {
        this.followVisible = followVisible;
        this.fansVisible = fansVisible;
        this.visitedVisible = visitedVisible;
        this.wantVisible = wantVisible;
        this.locationVisible = locationVisible;
        this.thumbupVisible = thumbupVisible;
        this.favoritesVisible = favoritesVisible;
        this.defaultFavoritesPublic = defaultFavoritesPublic;
    }


    public Long getUserId() {
        return userId;
    }

    public Byte getFollowVisible() {
        return followVisible;
    }

    public Byte getFansVisible() {
        return fansVisible;
    }

    public Byte getVisitedVisible() {
        return visitedVisible;
    }

    public Byte getWantVisible() {
        return wantVisible;
    }

    public Byte getLocationVisible() {
        return locationVisible;
    }

    public Byte getThumbupVisible() {
        return thumbupVisible;
    }

    public Byte getFavoritesVisible() {
        return favoritesVisible;
    }

    public Byte getDefaultFavoritesPublic() {
        return defaultFavoritesPublic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", followVisible=").append(followVisible);
        sb.append(", fansVisible=").append(fansVisible);
        sb.append(", visitedVisible=").append(visitedVisible);
        sb.append(", wantVisible=").append(wantVisible);
        sb.append(", locationVisible=").append(locationVisible);
        sb.append(", thumbupVisible=").append(thumbupVisible);
        sb.append(", favoritesVisible=").append(favoritesVisible);
        sb.append(", defaultFavoritesPublic=").append(defaultFavoritesPublic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}