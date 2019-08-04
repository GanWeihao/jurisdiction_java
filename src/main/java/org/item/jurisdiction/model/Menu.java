package org.item.jurisdiction.model;

public class Menu {
    private String menuId;

    private String menuName;

    public Menu(String menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public Menu() {
        super();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }
}