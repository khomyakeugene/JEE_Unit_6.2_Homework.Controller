package com.company.restaurant.model;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class StateGraphRules {
    public static final String STATE_TYPE_OPEN = "A";
    public static final String STATE_TYPE_CLOSED = "B";
    public static final String ACTION_TYPE_CREATION = "A";
    public static final String ACTION_TYPE_REMOVAL = "B";
    public static final String ACTION_TYPE_FILLING = "C";
    public static final String ACTION_TYPE_CLOSING = "D";
    public static final String ACTION_TYPE_VIEWING = "E";

    private StateGraphDao stateGraphDao;

    public void setStateGraphDao(StateGraphDao stateGraphDao) {
        this.stateGraphDao = stateGraphDao;
    }
}
