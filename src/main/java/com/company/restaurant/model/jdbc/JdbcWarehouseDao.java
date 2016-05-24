package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.Warehouse;
import com.company.restaurant.model.WarehouseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class JdbcWarehouseDao extends JdbcDaoAmountLinkTable<Warehouse> implements WarehouseDao {
    private static final String WAREHOUSE_TABLE_NAME = "warehouse";
    private static final String WAREHOUSE_VIEW_NAME = "v_warehouse";
    private static final String INGREDIENT_ID_FIELD_NAME = "ingredient_id";
    private static final String PORTION_ID_FIELD_NAME = "portion_id";
    private static final String AMOUNT_FIELD_NAME = "amount";
    private static final String INGREDIENT_NAME_FIELD_NAME = "ingredient_name";
    private static final String PORTION_TYPE_ID_FIELD_NAME = "portion_type_id";
    private static final String MEASURING_TYPE_ID_FIELD_NAME = "measuring_type_id";
    private static final String PORTION_AMOUNT_FIELD_NAME = "portion_amount";
    private static final String PORTION_DESCRIPTION_FIELD_NAME = "portion_description";
    private static final String PORTION_TYPE_NAME_FIELD_NAME = "portion_type_name";
    private static final String MEASURING_TYPE_CODE_FIELD_NAME = "measuring_type_code";
    private static final String MEASURING_TYPE_NAME_FIELD_NAME = "measuring_type_name";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY ingredient_name";
    private static final String SQL_SELECT_ELAPSING_WAREHOUSE_INGREDIENTS = "SELECT * FROM warehouse WHERE (amount < %f)";

    @Override
    protected void initMetadata() {
        this.tableName = WAREHOUSE_TABLE_NAME;
        this.viewName = WAREHOUSE_VIEW_NAME;
        this.firstIdFieldName = INGREDIENT_ID_FIELD_NAME;
        this.secondIdFieldName = PORTION_ID_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    @Override
    protected Map<String, Object> objectToDBMap(Warehouse object) {
        return null;
    }

    @Override
    protected Warehouse newObject(ResultSet resultSet) throws SQLException {
        Warehouse result = new Warehouse();
        result.setIngredientId(resultSet.getInt(INGREDIENT_ID_FIELD_NAME));
        result.setPortionId(resultSet.getInt(PORTION_ID_FIELD_NAME));
        result.setAmount(resultSet.getFloat(AMOUNT_FIELD_NAME));
        result.setIngredientName(resultSet.getString(INGREDIENT_NAME_FIELD_NAME));
        result.setPortionTypeId(resultSet.getInt(PORTION_TYPE_ID_FIELD_NAME));
        result.setMeasuringTypeId(resultSet.getInt(MEASURING_TYPE_ID_FIELD_NAME));
        result.setPortionAmount(resultSet.getFloat(PORTION_AMOUNT_FIELD_NAME));
        result.setPortionDescription(resultSet.getString(PORTION_DESCRIPTION_FIELD_NAME));
        result.setPortionTypeName(resultSet.getString(PORTION_TYPE_NAME_FIELD_NAME));
        result.setMeasuringTypeCode(resultSet.getString(MEASURING_TYPE_CODE_FIELD_NAME));
        result.setMeasuringTypeName(resultSet.getString(MEASURING_TYPE_NAME_FIELD_NAME));

        return result;
    }

    @Override
    public void addIngredientToWarehouse(Ingredient ingredient, Portion portion, float amount) {
        increaseAmount(ingredient.getIngredient(), portion.getPortionId(), amount);

    }

    @Override
    public void takeIngredientFromWarehouse(Ingredient ingredient, float amount) {
        decreaseAmount(ingredient.getIngredient(), findObjectByFieldCondition(INGREDIENT_ID_FIELD_NAME,
                ingredient.getIngredient()).getPortionId(), amount);
    }

    @Override
    public Warehouse findIngredientByName(String name) {
        return findObjectByFieldCondition(INGREDIENT_NAME_FIELD_NAME, name);
    }

    @Override
    public List<Warehouse> findAllWarehouseIngredients() {
        return findAllObjects();
    }

    @Override
    public List<Warehouse> findAllElapsingWarehouseIngredients(float limit) {
        return createObjectListFromQuery(String.format(SQL_SELECT_ELAPSING_WAREHOUSE_INGREDIENTS, limit));
    }
}