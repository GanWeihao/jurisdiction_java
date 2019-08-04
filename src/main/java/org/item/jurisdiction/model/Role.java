package org.item.jurisdiction.model;


public class Role {
    private String roleId;

    private String roleName;

    private Integer roleStatus;

    public Role(String roleId, String roleName, Integer roleStatus) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleStatus = roleStatus;
    }

    public Role() {
        super();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
}