package com.yauhenav;

import com.yauhenav.logic.exception.DaoException;
import com.yauhenav.logic.mysql.*;
import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;

import javax.management.*;
import java.sql.*;
/**
 * Created by yauhenav on 8.8.17.
 */
public class TestsHandler {
    private MySqlDaoFactory testMSDF;
    private StudentDao testMSSD;
    private SubjectDao testMSSubD;
    private MarkDao testMSMarD;
    SessionFactory factory = null;

    public TestsHandler() throws DaoException {
        try {
            this.factory = SessionUtilTest.getSessionFactory();
            testMSDF = new MySqlDaoFactory(factory);
            testMSSD = testMSDF.getStudentDao();
            testMSSubD = testMSDF.getSubjectDao();
            testMSMarD = testMSDF.getMarkDao();
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }

    public StudentDao getMySqlStudentDaoInstance() {
        return testMSSD;
    }

    public SubjectDao getMySqlSubjectDaoInstance() {
        return testMSSubD;
    }

    public MarkDao getMySqlMarkDaoInstance() {
        return testMSMarD;
    }


    public void populateDataBase() throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(new Student(1, "Testname", "Testsurname"));
            session.save(new Student(2, "Testnametwo", "Testsurnametwo"));
            session.save(new Subject(1, "Testsubjectone"));
            session.save(new Subject(2, "Testsubjecttwo"));
            session.save(new Mark(1, 10, 1, 1));
            session.save(new Mark(2, 9, 1, 2));
            session.save(new Mark(3, 8, 2, 1));
            session.save(new Mark(4, 7, 2, 2));
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
            Query query1 = session.createQuery("delete from Subject sub");
            query1.executeUpdate();
            Query query2 = session.createQuery("delete from Mark m");
            query2.executeUpdate();
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
