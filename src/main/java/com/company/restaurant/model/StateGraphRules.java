package com.company.restaurant.model;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class StateGraphRules {
    private static final String IMPOSSIBLE_TO_DETERMINE_CREATION_STATE_PATTERN =
            "It is impossible to determine <creation state> for entity <%s>!";

    private static final String STATE_TYPE_OPEN = "A";
    private static final String STATE_TYPE_CLOSED = "B";
    private static final String ACTION_TYPE_CREATION = "A";
    private static final String ACTION_TYPE_REMOVAL = "B";
    private static final String ACTION_TYPE_FILLING = "C";
    private static final String ACTION_TYPE_CLOSING = "D";
    private static final String ACTION_TYPE_VIEWING = "E";

    private StateGraphDao stateGraphDao;
    private HashMap<String, List<StateGraph>> entityStateGraphMap = new HashMap<>();

    public void setStateGraphDao(StateGraphDao stateGraphDao) {
        this.stateGraphDao = stateGraphDao;
    }

    private void ErrorMessage(String message) {
        throw new RuntimeException(message);
    }

    private List<StateGraph> entityGraphStateList(String entityName) {
        List<StateGraph> result = entityStateGraphMap.get(entityName);
        if (result == null) {
            result = stateGraphDao.findEntityStateGraph(entityName);
            entityStateGraphMap.put(entityName, result);
        }

        return result;
    }

    public String creationState(String entityName) {
        String result = null;

        Optional<StateGraph> optionalStateGraph = entityGraphStateList(entityName).stream().
                filter(s -> (s.getActionType().equals(ACTION_TYPE_CREATION)) &&
                        (s.getInitStateType().equals(s.getFiniteStateType()))).findFirst();
        if (optionalStateGraph.isPresent()) {
            result = optionalStateGraph.get().getInitStateType();
        } else {
            ErrorMessage(String.format(IMPOSSIBLE_TO_DETERMINE_CREATION_STATE_PATTERN, entityName));
        }

        return result;
    }
}
