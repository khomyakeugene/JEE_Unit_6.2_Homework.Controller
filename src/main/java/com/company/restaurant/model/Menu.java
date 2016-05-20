package com.company.restaurant.model;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class Menu {
    private int menuId;
    private String name;

    public Menu(int menuId, String name) {
        this.menuId = menuId;
        this.name = name;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
