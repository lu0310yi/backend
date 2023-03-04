package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class AttractionScore implements Serializable {
    private Long userId;

    private Long attractionId;

    private Double score;

    private static final long serialVersionUID = 1L;

    public AttractionScore(Long userId, Long attractionId, Double score) {
        this.userId = userId;
        this.attractionId = attractionId;
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAttractionId() {
        return attractionId;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", attractionId=").append(attractionId);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}