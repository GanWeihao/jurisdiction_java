package org.item.jurisdiction.model;

import java.util.Date;

public class Rules {
    private String rulesId;
    private String rulesMenuId;
    private String rulesName;
    private Date rulesTime;
    private Integer rulesStatus;
    private String rulesUrl;

    public Rules(String rulesId, String rulesMenuId, String rulesName, Date rulesTime, Integer rulesStatus, String rulesUrl) {
        this.rulesId = rulesId;
        this.rulesMenuId = rulesMenuId;
        this.rulesName = rulesName;
        this.rulesTime = rulesTime;
        this.rulesStatus = rulesStatus;
        this.rulesUrl = rulesUrl;
    }

    public Rules() {
    }

    public String getRulesId() {
        return this.rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = (rulesId == null) ? null : rulesId.trim();
    }

    public String getRulesMenuId() {
        return this.rulesMenuId;
    }

    public void setRulesMenuId(String rulesMenuId) {
        this.rulesMenuId = (rulesMenuId == null) ? null : rulesMenuId.trim();
    }

    public String getRulesName() {
        return this.rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = (rulesName == null) ? null : rulesName.trim();
    }

    public Date getRulesTime() {
        return this.rulesTime;
    }

    public void setRulesTime(Date rulesTime) {
        this.rulesTime = rulesTime;
    }

    public Integer getRulesStatus() {
        return this.rulesStatus;
    }

    public void setRulesStatus(Integer rulesStatus) {
        this.rulesStatus = rulesStatus;
    }

    public String getRulesUrl() {
        return this.rulesUrl;
    }

    public void setRulesUrl(String rulesUrl) {
        this.rulesUrl = rulesUrl;
    }
}