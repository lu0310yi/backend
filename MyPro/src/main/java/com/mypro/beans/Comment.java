package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class Comment implements Serializable {
    private Long commentId;

    private Long userId;

    private Long pacId;

    private Date gmtCreate;

    private String content;

    private Integer replyCount;

    private Integer thumbupCount;

    private String type;

    private static final long serialVersionUID = 1L;

    public Comment(Long commentId, Long userId, Long pacId, Date gmtCreate, String content, Integer replyCount, Integer thumbupCount, String type) {
        this.commentId = commentId;
        this.userId = userId;
        this.pacId = pacId;
        this.gmtCreate = gmtCreate;
        this.content = content;
        this.replyCount = replyCount;
        this.thumbupCount = thumbupCount;
        this.type = type;
    }

    public Long getCommentId() {
        return commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPacId() {
        return pacId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public String getContent() {
        return content;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public Integer getThumbupCount() {
        return thumbupCount;
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
        sb.append(", commentId=").append(commentId);
        sb.append(", userId=").append(userId);
        sb.append(", pacId=").append(pacId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", content=").append(content);
        sb.append(", replyCount=").append(replyCount);
        sb.append(", thumbupCount=").append(thumbupCount);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}