package org.item.jurisdiction.bo;

import java.util.Date;

import org.item.jurisdiction.model.Menu;

public class Rules_Menu {
    private String rulesId;
    private String rulesMenuId;
    private String rulesName;
    private Date rulesTime;
    private Integer rulesStatus;
    private String rulesUrl;
    private Menu menu;

    public Rules_Menu(String rulesId, String rulesMenuId, String rulesName, Date rulesTime, Integer rulesStatus, Menu menu, String rulesUrl) {
        this.rulesId = rulesId;

        this.rulesMenuId = rulesMenuId;

        this.rulesName = rulesName;

        this.rulesTime = rulesTime;

        this.rulesStatus = rulesStatus;

        this.menu = menu;

        this.rulesUrl = rulesUrl;

    }

    public Rules_Menu() {
    }

    public String getRulesId() {
        return this.rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId;
    }

    public String getRulesMenuId() {
        return this.rulesMenuId;
    }

    public void setRulesMenuId(String rulesMenuId) {
        this.rulesMenuId = rulesMenuId;
    }

    public String getRulesName() {
        return this.rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = rulesName;
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

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
