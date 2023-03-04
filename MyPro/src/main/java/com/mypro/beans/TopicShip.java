package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class TopicShip implements Serializable {
    private Long userId;

    private Long topicId;

    private Date gmtFollow;

    private static final long serialVersionUID = 1L;

    public TopicShip(Long userId, Long topicId, Date gmtFollow) {
        this.userId = userId;
        this.topicId = topicId;
        this.gmtFollow = gmtFollow;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public Date getGmtFollow() {
        return gmtFollow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", topicId=").append(topicId);
        sb.append(", gmtFollow=").append(gmtFollow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}