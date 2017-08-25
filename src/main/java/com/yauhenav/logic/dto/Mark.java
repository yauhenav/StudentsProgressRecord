package com.yauhenav.logic.dto;

import javax.persistence.*;

@Entity
@Table(name = "MARK", schema = "daotrain")
public class Mark {

    private int id;

    private int value;

    private int studentId;

    private int subjectId;

    public Mark() {
    }

    public Mark(int id) {
        this.id = id;
        value = 0;
        studentId = 0;
        subjectId = 0;
    }

    public Mark (int id, int value, int studentId, int subjectId) {
        this.id = id;
        this.value = value;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "VALUE")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String toString() {
        return "[" + this.studentId +"'s mark for " + this.subjectId + " is " + this.value + ", ID No." + this. id + "]";
    }
}
