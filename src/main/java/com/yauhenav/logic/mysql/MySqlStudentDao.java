package com.yauhenav.logic.mysql;

import java.util.*;

import com.yauhenav.logic.service.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;



public class MySqlStudentDao implements StudentDao {

    private Session session;

    // Constructor
    public MySqlStudentDao(Session session) {
        this.session = session;
    }

    // Create a new DB entry as per corresponding received object
    @Override
    public void create(Student student) throws DaoException {
        Transaction tx = session.beginTransaction();
        session.save (student);
        tx.commit();
    }

    // Return the object corresponding to the DB entry with received primary 'key'
    @Override
    public Student read(Student student) throws DaoException {
        Query<Student> query = session.createQuery("from Student s where s.id=:id", Student.class);
        query.setParameter ("id", student.getId());
        return query.uniqueResult();
    }

    // Modify the DB entry as per corresponding received object
    @Override
    public void update(Student student) throws DaoException {
        Transaction tx = session.beginTransaction();
        Query<Student> query = session.createQuery("from Student s where s.id=:id", Student.class);
        query.setParameter("id", student.getId());
        Student tempStud = query.uniqueResult();
        tempStud.setId (student.getId());
        tempStud.setName(student.getName());
        tempStud.setSurname(student.getSurname());
        tx.commit();
    }

    // Remove the DB entry as per corresponding received object
    @Override
    public void delete(Student student) throws DaoException {
        Transaction tx = session.beginTransaction();
        session.delete(student);
        tx.commit();
    }

    // Return a list of objects corresponding to all DB entries
    @Override
    public List<Student> getAll() throws DaoException {

        Query query = session.createQuery("from Student s");
        List<Student> lst = query.list();
        return lst;
    }
}

