package com.mypro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
public class Post implements Serializable {
    private Long postId;

    private Long authorId;

    private Date gmtCreate;

    private Date gmtEdit;

    private Long attractionId;

    private Long topicId;

    private String content;

    private List<String> images;

    private Integer commentCount;

    private Integer collectionCount;

    private Integer thumbupCount;

    private static final long serialVersionUID = 1L;

    public Post(Long postId, Long authorId, Date gmtCreate, Date gmtEdit, Long attractionId, Long topicId, String content, List<String> images, Integer commentCount, Integer collectionCount, Integer thumbupCount) {
        this.postId = postId;
        this.authorId = authorId;
        this.gmtCreate = gmtCreate;
        this.gmtEdit = gmtEdit;
        this.attractionId = attractionId;
        this.topicId = topicId;
        this.content = content;
        this.images = images;
        this.commentCount = commentCount;
        this.collectionCount = collectionCount;
        this.thumbupCount = thumbupCount;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtEdit() {
        return gmtEdit;
    }

    public Long getAttractionId() {
        return attractionId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getContent() {
        return content;
    }

    public List<String> getImages() {
        return images;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public Integer getCollectionCount() {
        return collectionCount;
    }

    public Integer getThumbupCount() {
        return thumbupCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", authorId=").append(authorId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtEdit=").append(gmtEdit);
        sb.append(", attractionId=").append(attractionId);
        sb.append(", topicId=").append(topicId);
        sb.append(", content=").append(content);
        sb.append(", images=").append(images);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", collectionCount=").append(collectionCount);
        sb.append(", thumbupCount=").append(thumbupCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}