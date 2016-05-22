package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 22.05.2016.
 */
public interface TableDao {
    int addTable(Table table);

    void delTable(Table table);

    Table findTableByNumber(int number);

    List<Table> findAllTables();
}