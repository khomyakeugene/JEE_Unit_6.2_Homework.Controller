package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 24.05.2016.
 */
public interface PortionDao {
    Portion addPortion(Portion portion);

    String delPortion(Portion portion);

    List<Portion> findAllPortions();
}
