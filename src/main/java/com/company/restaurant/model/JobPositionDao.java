package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public interface JobPositionDao {
    JobPosition addJobPosition(String name);

    void delJobPosition(String name);

    JobPosition findJobPositionByName(String name);

    List<JobPosition> findAllJobPositions();
}
