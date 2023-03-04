package com.mypro.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
public class Attraction implements Serializable {
    private Long attractionId;

    private String name;

    private String location;

    private String description;

    private Double score;

    private Double latitude;

    private Double longtitude;

    private Long visitedCount;

    private Long wantCount;

    private Long recommendCount;

    private String cover;

    private Long authorId;

    private Date gmtCreate;

    private static final long serialVersionUID = 1L;

    public Attraction(Long attractionId, String name, String location, String description, Double score, Double latitude, Double longtitude, Long visitedCount, Long wantCount, Long recommendCount, String cover, Long authorId, Date gmtCreate) {
        this.attractionId = attractionId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.score = score;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.visitedCount = visitedCount;
        this.wantCount = wantCount;
        this.recommendCount = recommendCount;
        this.cover = cover;
        this.authorId = authorId;
        this.gmtCreate = gmtCreate;
    }

    public Long getAttractionId() {
        return attractionId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Double getScore() {
        return score;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public Long getVisitedCount() {
        return visitedCount;
    }

    public Long getWantCount() {
        return wantCount;
    }

    public Long getRecommendCount() {
        return recommendCount;
    }

    public String getCover() {
        return cover;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attractionId=").append(attractionId);
        sb.append(", name=").append(name);
        sb.append(", location=").append(location);
        sb.append(", describe=").append(description);
        sb.append(", score=").append(score);
        sb.append(", latitude=").append(latitude);
        sb.append(", longtitude=").append(longtitude);
        sb.append(", visitedCount=").append(visitedCount);
        sb.append(", wantCount=").append(wantCount);
        sb.append(", recommendCount=").append(recommendCount);
        sb.append(", cover=").append(cover);
        sb.append(", authorId=").append(authorId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}