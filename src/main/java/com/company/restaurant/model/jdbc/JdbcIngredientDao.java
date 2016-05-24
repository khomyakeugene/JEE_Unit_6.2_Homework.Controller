package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.IngredientDao;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class JdbcIngredientDao extends JdbcDaoTableSimpleDic<Ingredient> implements IngredientDao {
    private static final String INGREDIENT_DIC_TABLE_NAME = "ingredient_dic";
    private static final String INGREDIENT_ID_FIELD_NAME = "ingredient_id";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY name";

    @Override
    public Ingredient addIngredient(String name) {
        return addRecord(name);
    }

    @Override
    public void delIngredient(String name) {
        delRecordByName(name);
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return findAllObjects();
    }

    @Override
    protected Ingredient newObject() {
        return new Ingredient();
    }

    @Override
    protected void initMetadata() {
        this.tableName = INGREDIENT_DIC_TABLE_NAME;
        this.idFieldName = INGREDIENT_ID_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }
}
