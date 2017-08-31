package com.yauhenav;

import org.testng.annotations.Test;

import com.yauhenav.logic.exception.DaoException;

import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.dao.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.AssertJUnit.*;

import java.sql.*;

/**
 * Created by yauhenav on 16.7.17.
 */
public class MySqlStudentDaoTest {

   private TestsHandler testHandler;
   private StudentDao testMSSD;

    @BeforeMethod
    public void fillDBWithTestData() throws SQLException, DaoException {
        try {
            testHandler = new TestsHandler();
            testHandler.populateDataBase();
            testMSSD = testHandler.getMySqlStudentDaoInstance();
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @AfterMethod
    public void wipeDBTestData() throws SQLException, DaoException {
        try {
            testHandler.emptyDataBase();
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestCreateStudentMethod () throws DaoException {
        try {
            Student testStudentPush = new Student (12, "Sherlock", "Holmes" );
            testMSSD.create(testStudentPush);
            Student testStudentPop = testMSSD.read(testStudentPush);
            assertEquals (testStudentPush.toString(), testStudentPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestReadStudentMethod () throws DaoException {
        try {
            Student testStudent = new Student (1, "Testname", "Testsurname");
            Student testStudentPop = testMSSD.read (testStudent);
            assertEquals (testStudent.toString(), testStudentPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }
}
