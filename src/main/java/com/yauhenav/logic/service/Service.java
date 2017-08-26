package com.yauhenav.logic.service;

import java.util.*;

import com.yauhenav.logic.dao.*;
import com.yauhenav.logic.dto.*;
import com.yauhenav.logic.exception.*;
import com.yauhenav.logic.mysql.*;

public class Service {

    private DaoFactory interDaoFact = null;
    private StudentDao interDaoStud = null;
    private SubjectDao interDaoSub = null;
    private MarkDao interDaoMar = null;

    // Constructor that establishes connection with the DB & creates required objects
    public Service() throws ServiceException {
        try {
            interDaoFact = new MySqlDaoFactory ();
            interDaoStud = interDaoFact.getStudentDao();
            interDaoSub = interDaoFact.getSubjectDao();
            interDaoMar = interDaoFact.getMarkDao();
        } catch (DaoException exc) {
            throw new ServiceException ("Exception in Service class", exc);
        }
    }

    // Retrieve one 'Student' DTO from the DB as per received ID
    public Student displayOneStudent (Student student) throws ServiceException {
        try {
            return interDaoStud.read(student);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    //Retrieve all 'Student' DTO's from the DB
    public List<Student> displayAllStudents() throws ServiceException {
        try {
            return interDaoStud.getAll();
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Add new entry into DB as per received attributes for a 'Student' DTO
    public void addStudent(Student stud) throws ServiceException {
        try {
            interDaoStud.create(stud);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Update existing DB entry as per received attributes for a 'Student' DTO
    public void updateStudent(Student stud) throws ServiceException {
        try {
            interDaoStud.update(stud);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Delete existing entry from DB as per received ID for a 'Student' DTO
    public void deleteStudent(Student stud) throws ServiceException {
        try {
            interDaoStud.delete (stud);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Retrieve one 'Subject' DTO from DB as per specified ID
    public Subject displayOneSubject(Subject subj) throws ServiceException {
        try {
            return interDaoSub.read(subj);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Retrieve all 'Subject' DTO's from the DB
    public List<Subject> displayAllSubjects() throws ServiceException {
        try {
            return interDaoSub.getAll();
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Add new entry into DB as per received attributes for a 'Subject' DTO
    public void addSubject(Subject subj) throws ServiceException {
        try {
            interDaoSub.create(subj);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Update existing DB entry as per received attributes for a 'Subject' DTO
    public void updateSubject(Subject subj) throws ServiceException {
        try {
            interDaoSub.update(subj);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Delete existing entry from DB as per received ID for a 'Subject' DTO
    public void deleteSubject(Subject subj) throws ServiceException {
        try {
            interDaoSub.delete (subj);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Retrieve one 'Mark' DTO from DB as per specified ID
    public Mark displayOneMark(Mark mrk) throws ServiceException {
        try {
            return interDaoMar.read(mrk);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Retrieve all 'Mark' DTO's from the DB
    public List<Mark> displayAllMarks() throws ServiceException {
        try {
            return interDaoMar.getAll();
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Retrieve all 'Mark' DTO's related to one 'Student' DTO as per received ID
    public List<Mark> displayMarksOneStud (Mark mrk) throws ServiceException {
        try {
            return interDaoMar.getAllMarkOneStud(mrk);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Add new entry into DB as per received attributes for a 'Mark' DTO
    public void addMark(Mark mrk) throws ServiceException {
        try {
            interDaoMar.create(mrk);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Update existing DB entry as per received attributes for a 'Mark' DTO
    public void updateMark(Mark mrk) throws ServiceException {
        try {
            interDaoMar.update(mrk);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Delete existing entry from DB as per received ID for a 'Mark' DTO
    public void deleteMark(Mark mrk) throws ServiceException {
        try {
            interDaoMar.delete (mrk);
        } catch (DaoException exc) {
            throw new ServiceException("Exception in Service class", exc);
        }
    }

    // Close all 'PreparedStatement' objects and the 'Connection' object
    public void close() throws ServiceException {
        try {
            interDaoFact.close();
        } catch (DaoException exc) {
            exc.printStackTrace();
        }
    }
}
