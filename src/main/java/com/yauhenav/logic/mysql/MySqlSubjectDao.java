package com.yauhenav.logic.mysql;

import java.util.*;

import org.hibernate.*;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

public class MySqlSubjectDao implements SubjectDao {

    private SessionFactory factory = null;

    // Constructor
    public MySqlSubjectDao(SessionFactory factory) throws DaoException {
        this.factory = factory;
    }

    // Create a new DB entry as per corresponding received object
    @Override
    public void create(Subject subject) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(subject);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println ("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlSubjectDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Return the object corresponding to the DB entry with received primary 'key'
    @Override
    public Subject read(Subject subject) throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query<Subject> query = session.createQuery("from Subject sub where sub.id=:id", Subject.class);
            query.setParameter("id", subject.getId());
            return query.uniqueResult();
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlSubjectDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Modify the DB entry as per corresponding received object
    @Override
    public void update(Subject subject) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query<Subject> query = session.createQuery("from Subject sub where sub.id=:id", Subject.class);
            query.setParameter("id", subject.getId());
            Subject tempSub = query.uniqueResult();
            tempSub.setId(subject.getId());
            tempSub.setDescription(subject.getDescription());
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println ("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlSubjectDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Remove the DB entry as per corresponding received object
    @Override
    public void delete(Subject subject) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.delete(subject);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println ("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlSubjectDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Return a list of objects corresponding to all DB entries
    @Override
    public List<Subject> getAll() throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Subject sub");
            List<Subject> lst = query.list();
            return lst;
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlSubjectDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }
}
