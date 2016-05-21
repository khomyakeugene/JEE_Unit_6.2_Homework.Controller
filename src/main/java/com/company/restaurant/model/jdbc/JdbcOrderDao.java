package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class JdbcOrderDao extends JdbcDaoTableWitId<Order> implements OrderDao {
    private static final String ORDER_TABLE_NAME = "order";
    private static final String ORDER_ID_FIELD_NAME = "order_id";
    private static final String TABLE_ID_FIELD_NAME = "table_id";
    private static final String STATE_TYPE_FIELD_NAME = "state_type";
    private static final String EMPLOYEE_ID_FIELD_NAME = "employee_id";
    private static final String ORDER_NUMBER_FIELD_NAME = "order_number";
    private static final String ORDER_DATETIME_FIELD_NAME = "order_datetime";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY order_id";

    public JdbcOrderDao() {
        this.tableName = ORDER_TABLE_NAME;
        this.idFieldName = ORDER_ID_FIELD_NAME;
        this.nameFieldName = ORDER_NUMBER_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    @Override
    protected void setId(int id, Order order) {
        order.setOrderId(id);
    }

    @Override
    protected Map<String, Object> objectToDBMap(Order order) {

        return null;
    }

    @Override
    protected Order newObject(ResultSet resultSet) throws SQLException {
        Order result = new Order();
        result.setOrderId(resultSet.getInt(ORDER_ID_FIELD_NAME));
        result.setTableId(resultSet.getInt(TABLE_ID_FIELD_NAME));
        result.setStateType(resultSet.getString(STATE_TYPE_FIELD_NAME));
        result.setEmployeeId(resultSet.getInt(EMPLOYEE_ID_FIELD_NAME));
        result.setOrderNumber(resultSet.getString(ORDER_NUMBER_FIELD_NAME));
        result.setOrderDatetime(resultSet.getTime(ORDER_DATETIME_FIELD_NAME));

        return result;
    }

    @Override
    public int addOrder(Order order) {
        return addRecord(order);
    }

    @Override
    public void delOrder(Order order) {
        delRecord(order);
    }

    @Override
    public Order findOrderById(int id) {
        return findObjectById(id);
    }

    @Override
    public List<Order> findAllOrders(char stateType) {
        return null;
    }

}
