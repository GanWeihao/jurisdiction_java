package org.item.jurisdiction.model;


public class UserRole {
    private String userRoleId;

    private String userRoleUserId;

    private String userRoleRoleId;

    public UserRole(String userRoleId, String userRoleUserId, String userRoleRoleId) {
        this.userRoleId = userRoleId;
        this.userRoleUserId = userRoleUserId;
        this.userRoleRoleId = userRoleRoleId;
    }

    public UserRole() {
        super();
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getUserRoleUserId() {
        return userRoleUserId;
    }

    public void setUserRoleUserId(String userRoleUserId) {
        this.userRoleUserId = userRoleUserId == null ? null : userRoleUserId.trim();
    }

    public String getUserRoleRoleId() {
        return userRoleRoleId;
    }

    public void setUserRoleRoleId(String userRoleRoleId) {
        this.userRoleRoleId = userRoleRoleId == null ? null : userRoleRoleId.trim();
    }
}