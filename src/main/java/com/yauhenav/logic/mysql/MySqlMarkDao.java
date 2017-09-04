package com.yauhenav.logic.mysql;

import java.util.*;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

public class MySqlMarkDao implements MarkDao {
    private SessionFactory factory;

    // Constructor
    public MySqlMarkDao(SessionFactory factory) throws DaoException {
        this.factory = factory;
    }

    // Create a new DB entry as per corresponding received object
    @Override
    public void create(Mark mark) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(mark);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println ("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlMarkDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Return the object corresponding to the DB entry with received primary 'key'
    @Override
    public Mark read(Mark mark) throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query<Mark> query = session.createQuery("from Mark m where m.id=:id", Mark.class);
            query.setParameter("id", mark.getId());
            return query.uniqueResult();
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlMarkDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Modify the DB entry as per corresponding received object
    @Override
    public void update(Mark mark) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            Query<Mark> query = session.createQuery("from Mark m where m.id=:id", Mark.class);
            query.setParameter("id", mark.getId());
            Mark tempMark = query.uniqueResult();
            tempMark.setId(mark.getId());
            tempMark.setValue(mark.getValue());
            tempMark.setStudentId(mark.getStudentId());
            tempMark.setSubjectId(mark.getSubjectId());
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println ("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlMarkDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Remove the DB entry as per corresponding received object
    @Override
    public void delete(Mark mark) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.delete(mark);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch (NullPointerException npe) {
                System.err.println ("Couldn't roll back transaction");
                npe.printStackTrace();
            }
            throw new DaoException("Exception in MySqlMarkDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Return a list of objects corresponding to all DB entries
    @Override
    public List<Mark> getAll() throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Mark m");
            List<Mark> lst = query.list();
            return lst;
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlMarkDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }

    // Return a list of Marks of one Student as per received primary 'key'
    @Override
    public List<Mark> getAllMarkOneStud (Mark mark) throws DaoException {
        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Mark m where m.studentId=:studentId");
            query.setParameter("studentId", mark.getStudentId());
            List<Mark> lst = query.list();
            return lst;
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlMarkDao object", exc);
        } finally {
            if (session!=null) {
                session.close();
            }
        }
    }
}
