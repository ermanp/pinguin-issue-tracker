package com.pinguin.model;

import javax.persistence.*;

@Entity
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long issueId;
    private String title;
    private String description;

    private String createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    private String status;
    private String priority;

    public Bug() {
    }

    public Bug(String title, String description, String createdAt, String status, String priority) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
        this.priority = priority;
    }

    public Bug(String title, String description, String createdAt, Developer developer, String status, String priority) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.developer = developer;
        this.status = status;
        this.priority = priority;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
