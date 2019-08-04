package org.item.jurisdiction.model;

import java.util.Date;

public class User {
    private String userId;

    private String userName;

    private String userPassword;

    private String userTelphone;

    private String userEmail;

    private Date userTime;

    private Integer userStatus;

    private Integer userError;

    private String userHeadimg;

    public User(String userId, String userName, String userPassword, String userTelphone, String userEmail, Date userTime, Integer userStatus, Integer userError, String userHeadimg) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userTelphone = userTelphone;
        this.userEmail = userEmail;
        this.userTime = userTime;
        this.userStatus = userStatus;
        this.userError = userError;
        this.userHeadimg = userHeadimg;
    }

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserTelphone() {
        return userTelphone;
    }

    public void setUserTelphone(String userTelphone) {
        this.userTelphone = userTelphone == null ? null : userTelphone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserError() {
        return userError;
    }

    public void setUserError(Integer userError) {
        this.userError = userError;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }
}