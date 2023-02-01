package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class Topic implements Serializable {
    private Long topicId;

    private String name;

    private String description;

    private Long authorId;

    private Date gmtCreate;

    private Long visitedCount;

    private Long followCount;

    private static final long serialVersionUID = 1L;

    public Topic(Long topicId, String name, String description, Long authorId, Date gmtCreate, Long visitedCount, Long followCount) {
        this.topicId = topicId;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.gmtCreate = gmtCreate;
        this.visitedCount = visitedCount;
        this.followCount = followCount;
    }

    public Long getTopicId() {
        return topicId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Long getVisitedCount() {
        return visitedCount;
    }

    public Long getFollowCount() {
        return followCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", topicId=").append(topicId);
        sb.append(", name=").append(name);
        sb.append(", describe=").append(description);
        sb.append(", authorId=").append(authorId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", visitedCount=").append(visitedCount);
        sb.append(", followCount=").append(followCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}