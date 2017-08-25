package com.yauhenav.logic.mysql;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.exception.*;
import com.yauhenav.logic.service.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MySqlDaoFactory implements DaoFactory {
    private Session session;

    // Constructor
    public MySqlDaoFactory() {

        SessionFactory factory = SessionUtil.getSessionFactory();
        this.session = factory.openSession();
    }

    @Override
    public StudentDao getStudentDao() throws DaoException {
        return new MySqlStudentDao(session);
    }

    @Override
    public SubjectDao getSubjectDao() throws DaoException {
        return new MySqlSubjectDao(session);
    }

    @Override
    public MarkDao getMarkDao() throws DaoException {
        return new MySqlMarkDao(session);
    }

    // Close Session instance object
    @Override
    public void close() throws DaoException {
        session.close();
    }
}
