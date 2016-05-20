package com.company.restaurant.controllers;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class EmployeeControllerTest {
    private static EmployeeController employeeController;

    @BeforeClass
    public static void setUpClass() throws Exception {
        employeeController = EmployeeController.getInstance();
    }

    @Test
    public void addFindDelEmployeeTest() throws Exception {
        // Generate test <Employee>

    }

}