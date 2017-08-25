package com.yauhenav.logic.dto;

import javax.persistence.*;

@Entity
@Table (name = "SUBJECT", schema = "daotrain")
public class Subject {

    private int id;
    private String description;

    public Subject() {
    }

    public Subject(int id) {
        this.id = id;
        description = null;
    }

    public Subject(int id, String description) {
        this.id = id;
        this.description = description;
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
    @Column(name = "DESCRIPTION")
    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[Subject description: " + this.description + ", ID No." + this. id + "]";
    }
}
