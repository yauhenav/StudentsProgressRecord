package com.yauhenav.logic.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

public class MySqlSubjectDao implements SubjectDao {

    Session session = null;

    // Constructor
    public MySqlSubjectDao(Session session) throws DaoException {
        this.session = session;
    }

    // Create a new DB entry as per corresponding received object
    @Override
    public void create(Subject subject) throws DaoException {

    }

    // Return the object corresponding to the DB entry with received primary 'key'
    @Override
    public Subject read(Subject subject) throws DaoException {
        return null;
    }

    // Modify the DB entry as per corresponding received object
    @Override
    public void update(Subject subject) throws DaoException {

    }

    // Remove the DB entry as per corresponding received object
    @Override
    public void delete(Subject subject) throws DaoException {

    }

    // Return a list of objects corresponding to all DB entries
    @Override
    public List<Subject> getAll() throws DaoException {
        return null;
    }
}
