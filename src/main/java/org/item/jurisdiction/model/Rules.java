package org.item.jurisdiction.model;


import java.util.Date;

public class Rules {
    private String rulesId;

    private String rulesMenuId;

    private String rulesName;

    private Date rulesTime;

    private Integer rulesStatus;

    public Rules(String rulesId, String rulesMenuId, String rulesName, Date rulesTime, Integer rulesStatus) {
        this.rulesId = rulesId;
        this.rulesMenuId = rulesMenuId;
        this.rulesName = rulesName;
        this.rulesTime = rulesTime;
        this.rulesStatus = rulesStatus;
    }

    public Rules() {
        super();
    }

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId == null ? null : rulesId.trim();
    }

    public String getRulesMenuId() {
        return rulesMenuId;
    }

    public void setRulesMenuId(String rulesMenuId) {
        this.rulesMenuId = rulesMenuId == null ? null : rulesMenuId.trim();
    }

    public String getRulesName() {
        return rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = rulesName == null ? null : rulesName.trim();
    }

    public Date getRulesTime() {
        return rulesTime;
    }

    public void setRulesTime(Date rulesTime) {
        this.rulesTime = rulesTime;
    }

    public Integer getRulesStatus() {
        return rulesStatus;
    }

    public void setRulesStatus(Integer rulesStatus) {
        this.rulesStatus = rulesStatus;
    }
}