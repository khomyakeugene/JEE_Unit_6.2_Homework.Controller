package com.company.restaurant.model;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class Table extends SimpleDic {
    private String description;

    public int getTableId() {
        return getId();
    }

    public void setTableId(int tableId) {
        setId(tableId);
    }

    public int getNumber() {
        return Integer.parseInt(getName());
    }

    public void setNumber(int number) {
        setName(Integer.toString(number));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
