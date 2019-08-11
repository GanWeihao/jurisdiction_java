package org.item.jurisdiction.model;


public class Menu {
    private String menuId;

    public Menu(String menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }


    private String menuName;

    public Menu() {
    }

    public String getMenuId() {
        return this.menuId;
    }


    public void setMenuId(String menuId) {
        this.menuId = (menuId == null) ? null : menuId.trim();
    }


    public String getMenuName() {
        return this.menuName;
    }


    public void setMenuName(String menuName) {
        this.menuName = (menuName == null) ? null : menuName.trim();
    }
}