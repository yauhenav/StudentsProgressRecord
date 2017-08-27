package com.yauhenav.logic.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;

public class MySqlMarkDao implements MarkDao {
    private SessionFactory factory = null;

    // Constructor
    public MySqlMarkDao(SessionFactory factory) throws DaoException {
        this.factory = factory;
    }

    // Create a new DB entry as per corresponding received object
    @Override
    public void create(Mark mark) throws DaoException {

    }

    // Return the object corresponding to the DB entry with received primary 'key'
    @Override
    public Mark read(Mark mark) throws DaoException {
        return null;
    }

    // Modify the DB entry as per corresponding received object
    @Override
    public void update(Mark mark) throws DaoException {

    }

    // Remove the DB entry as per corresponding received object
    @Override
    public void delete(Mark mark) throws DaoException {

    }

    // Return a list of objects corresponding to all DB entries
    @Override
    public List<Mark> getAll() throws DaoException {
        return null;
    }

    // Return a list of Marks of one Student as per received primary 'key'
    @Override
    public List<Mark> getAllMarkOneStud (Mark mark) throws DaoException {
        return null;
    }
}
