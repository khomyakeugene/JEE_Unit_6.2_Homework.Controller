package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.JobPosition;
import com.company.restaurant.model.JobPositionDao;

import java.util.List;

/**
 * Created by Yevhen on 21.05.2016.
 */
public class JdbcJobPositionDao extends JdbcDaoTableSimpleDic<JobPosition> implements JobPositionDao {
    private static final String JOB_POSITION_DIC_TABLE_NAME = "job_position_dic";
    private static final String JOB_POSITION_ID_FIELD_NAME = "job_position_id";

    public JdbcJobPositionDao() {
        super();

        this.tableName = JOB_POSITION_DIC_TABLE_NAME;
        this.idFieldName = JOB_POSITION_ID_FIELD_NAME;
    }

    @Override
    public JobPosition addJobPosition(String name) {
        return addRecord(name);
    }

    @Override
    public void delJobPosition(String name) {
        delRecordByName(name);
    }

    @Override
    public JobPosition findJobPositionByName(String name) {
        return findObjectByName(name);
    }

    @Override
    public List<JobPosition> findAllJobPositions() {
        return findAllObjects();
    }

    @Override
    protected JobPosition newObject() {
        return new JobPosition();
    }
}