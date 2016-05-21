package com.company.restaurant.model;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class Table {
    private int tableId;
    private int number;
    private String description;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
