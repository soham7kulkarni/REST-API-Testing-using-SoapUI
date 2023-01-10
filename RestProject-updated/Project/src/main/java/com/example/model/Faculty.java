package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Faculty")
public class Faculty {

    @Id
    @Column(name="Faculty_ID")
    private int faculty_ID;
    @Column(name="Faculty_Name")
    private String faculty_Name;
    @Column(name="Department")
    private String department;
    @Column(name="Course")
    private String course;
    @Column(name="Office_room_no")
    private String office_room_no;

    public int getFaculty_ID() {
        return faculty_ID;
    }

    public void setFaculty_ID(int faculty_ID) {
        this.faculty_ID = faculty_ID;
    }

    public String getFaculty_Name() {
        return faculty_Name;
    }

    public void setFaculty_Name(String faculty_Name) {
        this.faculty_Name = faculty_Name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getOffice_room_no() {
        return office_room_no;
    }

    public void setOffice_room_no(String office_room_no) {
        this.office_room_no = office_room_no;
    }
}
