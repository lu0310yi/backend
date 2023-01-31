package com.mypro.beans;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Favorites implements Serializable {
    private Long userId;

    private Long folderId;

    private String name;

    private String description;

    private Boolean isPublic;

    private Integer itemCount;

    private Integer followCount;

    private Integer visitedCount;

    private Integer thumbupCount;

    private String cover;

    private Date gmtCreate;

    private Date gmtEdit;

    private static final long serialVersionUID = 1L;

    public Favorites(Long userId, Long folderId, String name, String description, Boolean isPublic, Integer itemCount, Integer followCount, Integer visitedCount, Integer thumbupCount, String cover, Date gmtCreate, Date gmtEdit) {
        this.userId = userId;
        this.folderId = folderId;
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
        this.itemCount = itemCount;
        this.followCount = followCount;
        this.visitedCount = visitedCount;
        this.thumbupCount = thumbupCount;
        this.cover = cover;
        this.gmtCreate = gmtCreate;
        this.gmtEdit = gmtEdit;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public Integer getVisitedCount() {
        return visitedCount;
    }

    public Integer getThumbupCount() {
        return thumbupCount;
    }

    public String getCover() {
        return cover;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtEdit() {
        return gmtEdit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", folderId=").append(folderId);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", isPublic=").append(isPublic);
        sb.append(", itemCount=").append(itemCount);
        sb.append(", followCount=").append(followCount);
        sb.append(", visitedCount=").append(visitedCount);
        sb.append(", thumbupCount=").append(thumbupCount);
        sb.append(", cover=").append(cover);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtEdit=").append(gmtEdit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}