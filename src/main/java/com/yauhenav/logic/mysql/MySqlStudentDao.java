package com.yauhenav.logic.mysql;

import java.util.*;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;



public class MySqlStudentDao implements StudentDao {

    private SessionFactory factory;

    // Constructor
    public MySqlStudentDao(SessionFactory factory) {
        this.factory = factory;
    }

    // Create a new DB entry as per corresponding received object
    @Override
    public void create(Student student) throws DaoException {
        Session session = null;
        Transaction tx = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (HibernateException exc) {
            try {
                tx.rollback();
            } catch ()
            throw new DaoException("Exception in MySqlStudentDao object", exc);
        }
    }

    // Return the object corresponding to the DB entry with received primary 'key'
    @Override
    public Student read(Student student) throws DaoException {
        try {
            Query<Student> query = session.createQuery("from Student s where s.id=:id", Student.class);
            query.setParameter("id", student.getId());
            return query.uniqueResult();
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlStudentDao object", exc);
        }
    }

    // Modify the DB entry as per corresponding received object
    @Override
    public void update(Student student) throws DaoException {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery("from Student s where s.id=:id", Student.class);
            query.setParameter("id", student.getId());
            Student tempStud = query.uniqueResult();
            tempStud.setId(student.getId());
            tempStud.setName(student.getName());
            tempStud.setSurname(student.getSurname());
            tx.commit();
        }catch (HibernateException exc) {
            tx.rollback();
            throw new DaoException("Exception in MySqlStudentDao object", exc);
        }
    }

    // Remove the DB entry as per corresponding received object
    @Override
    public void delete(Student student) throws DaoException {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(student);
            tx.commit();
        } catch (HibernateException exc) {
            if (tx!=null) {
                tx.rollback();
            }
            session.close();
            throw new DaoException("Exception in MySqlStudentDao object", exc);
        }
    }

    // Return a list of objects corresponding to all DB entries
    @Override
    public List<Student> getAll() throws DaoException {
        try {
            Query query = session.createQuery("from Student s");
            List<Student> lst = query.list();
            return lst;
        } catch (HibernateException exc) {
            throw new DaoException("Exception in MySqlStudentDao object", exc);
        }
    }
}

