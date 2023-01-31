package com.mypro.beans;

import java.io.Serializable;
import java.util.Date;

public class Collection implements Serializable {
    private Long userId;

    private Long folderId;

    private Long postArticleId;

    private Date gmtCollect;

    private String type;

    private static final long serialVersionUID = 1L;

    public Collection(Long userId, Long folderId, Long postArticleId, Date gmtCollect, String type) {
        this.userId = userId;
        this.folderId = folderId;
        this.postArticleId = postArticleId;
        this.gmtCollect = gmtCollect;
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public Long getPostArticleId() {
        return postArticleId;
    }

    public Date getGmtCollect() {
        return gmtCollect;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", folderId=").append(folderId);
        sb.append(", postArticleId=").append(postArticleId);
        sb.append(", gmtCollect=").append(gmtCollect);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}