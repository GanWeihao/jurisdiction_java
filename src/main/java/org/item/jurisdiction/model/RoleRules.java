package org.item.jurisdiction.model;

public class RoleRules {
    private String roleRulesId;
    private String roleRulesRoleId;
    private String roleRulesRulesId;

    public RoleRules(String roleRulesId, String roleRulesRoleId, String roleRulesRulesId) {
        this.roleRulesId = roleRulesId;
        this.roleRulesRoleId = roleRulesRoleId;
        this.roleRulesRulesId = roleRulesRulesId;
    }

    public RoleRules() {
    }

    public String getRoleRulesId() {
        return this.roleRulesId;
    }

    public void setRoleRulesId(String roleRulesId) {
        this.roleRulesId = (roleRulesId == null) ? null : roleRulesId.trim();
    }

    public String getRoleRulesRoleId() {
        return this.roleRulesRoleId;
    }

    public void setRoleRulesRoleId(String roleRulesRoleId) {
        this.roleRulesRoleId = (roleRulesRoleId == null) ? null : roleRulesRoleId.trim();
    }

    public String getRoleRulesRulesId() {
        return this.roleRulesRulesId;
    }

    public void setRoleRulesRulesId(String roleRulesRulesId) {
        this.roleRulesRulesId = (roleRulesRulesId == null) ? null : roleRulesRulesId.trim();
    }
}