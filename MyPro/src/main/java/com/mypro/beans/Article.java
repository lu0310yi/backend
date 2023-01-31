package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class Article implements Serializable {
    private Long articleId;

    private Long authorId;

    private Date gmtCreate;

    private Date gmtEdit;

    private Long attractionId;

    private Long topicId;

    private String title;

    private Integer commentCount;

    private Integer collectionCount;

    private Integer thumbupCount;

    private String content;

    private static final long serialVersionUID = 1L;
    public Article(Long articleId, Long authorId, Date gmtCreate, Date gmtEdit, Long attractionId, Long topicId, String title, Integer commentCount, Integer collectionCount, Integer thumbupCount, String content) {
        this.articleId = articleId;
        this.authorId = authorId;
        this.gmtCreate = gmtCreate;
        this.gmtEdit = gmtEdit;
        this.attractionId = attractionId;
        this.topicId = topicId;
        this.title = title;
        this.commentCount = commentCount;
        this.collectionCount = collectionCount;
        this.thumbupCount = thumbupCount;
        this.content = content;
    }
//    public Article(Long articleId, Long authorId, Date gmtCreate, Date gmtEdit, Long attractionId, Long topicId, String title, Integer commentCount, Integer collectionCount, Integer thumbupCount) {
//        this.articleId = articleId;
//        this.authorId = authorId;
//        this.gmtCreate = gmtCreate;
//        this.gmtEdit = gmtEdit;
//        this.attractionId = attractionId;
//        this.topicId = topicId;
//        this.title = title;
//        this.commentCount = commentCount;
//        this.collectionCount = collectionCount;
//        this.thumbupCount = thumbupCount;
//    }


    public Long getArticleId() {
        return articleId;
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

    public String getTitle() {
        return title;
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

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(articleId);
        sb.append(", authorId=").append(authorId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtEdit=").append(gmtEdit);
        sb.append(", attractionId=").append(attractionId);
        sb.append(", topicId=").append(topicId);
        sb.append(", title=").append(title);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", collectionCount=").append(collectionCount);
        sb.append(", thumbupCount=").append(thumbupCount);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}