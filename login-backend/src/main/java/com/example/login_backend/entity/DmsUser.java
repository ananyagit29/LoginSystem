package com.example.login_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dms_user")
public class DmsUser {

    @Id
    private String userId;

    private String password;

    private String activeStatus;

    private Integer failedAttempts = 0;  // Initialize to 0

    // Default constructor (required by JPA)
    public DmsUser() {
        this.failedAttempts = 0;
        this.activeStatus = "ACTIVE";
    }

    // Parameterized constructor
    public DmsUser(String userId, String password,String activeStatus, Integer failedAttempts) {
        this.userId = userId;
        this.password = password;
        this.activeStatus = activeStatus;
        this.failedAttempts = failedAttempts != null ? failedAttempts : 0;
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }
}
