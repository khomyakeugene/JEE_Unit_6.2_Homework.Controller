package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.IntegerLinkObject;

/**
 * Created by Yevhen on 23.05.2016.
 */
public class JdbcDaoQuantityLinkTable<T extends IntegerLinkObject> extends JdbcDaoLinkTable<T> {
    private Integer selectCurrentQuantity(int firstId, int secondId) {
        String stringResult = getOneFieldByTwoFieldCondition(thirdFieldName, firstId, secondId);

        return (stringResult == null) ? null : Integer.parseInt(stringResult);
    }

    public void increaseQuantity(int firstId, int secondId, int increasePortion) {
        Integer currentQuantity = selectCurrentQuantity(firstId, secondId);
        if (currentQuantity == null) {
            if (increasePortion > 0) {
                addRecord(firstId, secondId, String.valueOf(increasePortion));
            }
        } else {
            currentQuantity += increasePortion;
            if (currentQuantity > 0) {
                updRecord(firstId, secondId, currentQuantity);
            } else {
                delRecord(firstId, secondId);
            }
        }
    }

    public void decreaseQuantity(int firstId, int secondId, int decreasePortion) {
        increaseQuantity(firstId, secondId, -decreasePortion);
    }
}
