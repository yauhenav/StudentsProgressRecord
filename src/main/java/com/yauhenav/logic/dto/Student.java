package com.yauhenav.logic.dto;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT", schema = "daotrain")
public class Student {

    private int id;
    private String name;
    private String surname;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
        name = null;
        surname = null;
    }

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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
    @Column(name = "NAME")
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SURNAME")
    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "[Student's name: " + this.name + " " + this.surname + ", ID No." + this. id + "]";
    }
}
