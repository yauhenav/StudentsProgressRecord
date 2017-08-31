package com.yauhenav;

import com.yauhenav.logic.exception.DaoException;
import com.yauhenav.logic.mysql.*;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;

import java.sql.*;
/**
 * Created by yauhenav on 8.8.17.
 */
public class TestsHandler {
    private MySqlDaoFactory testMSDF;
    private StudentDao testMSSD;
    SessionFactory factory = null;

    public TestsHandler() throws DaoException {
        try {
            this.factory = SessionUtilTest.getSessionFactory();
            testMSDF = new MySqlDaoFactory(factory);
            testMSSD = testMSDF.getStudentDao();
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    public StudentDao getMySqlStudentDaoInstance() {
        return testMSSD;
    }

    public void populateDataBase() throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(new Student(1, "Testname", "Testsurname"));
            session.save(new Student(2, "Testnametwo", "Testsurnametwo"));
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in TestHandler object", exc);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void emptyDataBase() throws SQLException, DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from Student s");
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in TestHandler object", exc);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
