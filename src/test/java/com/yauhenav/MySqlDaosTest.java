package com.yauhenav;


import java.util.*;
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
public class MySqlDaosTest {

   private TestsHandler testHandler;
   private StudentDao testMSSD;
   private SubjectDao testMSSubD;
   private MarkDao testMSMarD;

    @BeforeMethod
    public void fillDBWithTestData() throws SQLException, DaoException {
        try {
            testHandler = new TestsHandler();
            testHandler.populateDataBase();
            testMSSD = testHandler.getMySqlStudentDaoInstance();
            testMSSubD = testHandler.getMySqlSubjectDaoInstance();
            testMSMarD = testHandler.getMySqlMarkDaoInstance();
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

    @Test
    public void TestUpdateStudentMethod() throws DaoException {
        try {
            Student testStudentUpd = new Student(2, "Updatedstudtwoname", "Updatedstudtwosurname");
            testMSSD.update (testStudentUpd);
            Student testStudentPop = testMSSD.read(testStudentUpd);
            assertEquals(testStudentUpd.toString(), testStudentPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestDeleteStudentMethod() throws DaoException {
        try {
            Student testStudentDel = new Student (1,"Testname", "Testsurname");
            testMSSD.delete(testStudentDel);
            assertNull(testMSSD.read(testStudentDel));
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestGetAllStudents() throws DaoException {
        try {
            List <Student> lst = testMSSD.getAll();
            assertEquals ("[[Student's name: Testname Testsurname, ID No.1], [Student's name: Testnametwo Testsurnametwo, ID No.2]]", lst.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestCreateSubjectMethod () throws DaoException {
        try {
            Subject testSubjectPush = new Subject (3, "Springcourse");
            testMSSubD.create(testSubjectPush);
            Subject testSubjectPop = testMSSubD.read(testSubjectPush);
            assertEquals (testSubjectPush.toString(), testSubjectPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestReadSubjectMethod () throws DaoException {
        try {
            Subject testSubject = new Subject (1, "Testsubjectone");
            Subject testSubjectPop = testMSSubD.read (testSubject);
            assertEquals (testSubject.toString(), testSubjectPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestUpdateSubjectMethod() throws DaoException {
        try {
            Subject testSubjectUpd = new Subject(2, "Updatedsubjecttwodescription");
            testMSSubD.update (testSubjectUpd);
            Subject testSubjectPop = testMSSubD.read(testSubjectUpd);
            assertEquals(testSubjectUpd.toString(), testSubjectPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestDeleteSubjectMethod() throws DaoException {
        try {
            Subject testSubjectDel = new Subject (1,"Testdescription");
            testMSSubD.delete(testSubjectDel);
            assertNull(testMSSubD.read(testSubjectDel));
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestGetAllSubjects() throws DaoException {
        try {
            List<Subject> lst = testMSSubD.getAll();
            assertEquals("[[Subject description: Testsubjectone, ID No.1], [Subject description: Testsubjecttwo, ID No.2]]", lst.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestCreateMarkMethod () throws DaoException {
        try {
            Mark testMarkPush = new Mark (5, 8, 1, 2);
            testMSMarD.create(testMarkPush);
            Mark testMarkPop = testMSMarD.read(testMarkPush);
            assertEquals (testMarkPush.toString(), testMarkPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestReadMarkMethod () throws DaoException {
        try {
            Mark testMark = new Mark (1, 10, 1, 1);
            Mark testMarkPop = testMSMarD.read (testMark);
            assertEquals (testMark.toString(), testMarkPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestUpdateMarkMethod() throws DaoException {
        try {
            Mark testMarkUpd = new Mark(2, 10, 1, 1);
            testMSMarD.update (testMarkUpd);
            Mark testMarkPop = testMSMarD.read(testMarkUpd);
            assertEquals(testMarkUpd.toString(), testMarkPop.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestDeleteMarkMethod() throws DaoException {
        try {
            Mark testMarkDel = new Mark (3, 1, 1, 1);
            testMSMarD.delete(testMarkDel);
            assertNull(testMSMarD.read(testMarkDel));
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestGetAllMarksMethod() throws DaoException {
        try {
            List <Mark> lst = testMSMarD.getAll();
            assertEquals ("[[1's mark for 1 is 10, ID No.1], [1's mark for 2 is 9, ID No.2], " +
                    "[2's mark for 1 is 8, ID No.3], [2's mark for 2 is 7, ID No.4]]", lst.toString());
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    @Test
    public void TestGetAllMarkOneStudMethod() throws DaoException {
        try {
            List<Mark> lst = testMSMarD.getAllMarkOneStud(new Mark(5, 0, 1, 0));
            assertEquals ("[[1's mark for 1 is 10, ID No.1], [1's mark for 2 is 9, ID No.2]]", lst.toString());
        } catch (DaoException exc) {
        exc.printStackTrace();
        }
    }
}
