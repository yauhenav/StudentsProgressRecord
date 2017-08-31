package com.yauhenav.logic.mysql;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.exception.*;
import com.yauhenav.logic.service.SessionUtilProd;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MySqlDaoFactory implements DaoFactory {

    private SessionFactory factory;

    // Constructor
    public MySqlDaoFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public StudentDao getStudentDao() throws DaoException {
        return new MySqlStudentDao(factory);
    }

    @Override
    public SubjectDao getSubjectDao() throws DaoException {
        return new MySqlSubjectDao(factory);
    }

    @Override
    public MarkDao getMarkDao() throws DaoException {
        return new MySqlMarkDao(factory);
    }

    // Terminate the Session instance object
    @Override
    public void close() throws DaoException {
        if (factory != null) {
            try {
                factory.close();
            } catch (HibernateException exc) {
                throw new DaoException("Exception in MySqlDaoFactory", exc);
            }
        } else {
            System.err.println("SessionFactory object was not created");
        }
    }
}
