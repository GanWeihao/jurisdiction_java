package org.item.jurisdiction.bo;

import org.item.jurisdiction.model.Menu;

import java.util.Date;

public class Rules_Menu {
    private String rulesId;

    private String rulesMenuId;

    private String rulesName;

    private Date rulesTime;

    private Integer rulesStatus;

    private Menu menu;

    public Rules_Menu(String rulesId, String rulesMenuId, String rulesName, Date rulesTime, Integer rulesStatus, Menu menu) {
        this.rulesId = rulesId;
        this.rulesMenuId = rulesMenuId;
        this.rulesName = rulesName;
        this.rulesTime = rulesTime;
        this.rulesStatus = rulesStatus;
        this.menu = menu;
    }

    public Rules_Menu() {
        super();
    }

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId;
    }

    public String getRulesMenuId() {
        return rulesMenuId;
    }

    public void setRulesMenuId(String rulesMenuId) {
        this.rulesMenuId = rulesMenuId;
    }

    public String getRulesName() {
        return rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = rulesName;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
