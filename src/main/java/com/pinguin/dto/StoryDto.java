package com.pinguin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StoryDto {

    private String issueId;
    private String title;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String createdAt;
    private String developerId;
    private String status;
    private int estimatedPoint;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEstimatedPoint() {
        return estimatedPoint;
    }

    public void setEstimatedPoint(int estimatedPoint) {
        this.estimatedPoint = estimatedPoint;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
