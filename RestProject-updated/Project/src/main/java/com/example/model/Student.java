package com.example.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name="Student")
public class Student {

    @Id
    @Column(name="Student_ID")
    private int student_ID;
    @Column(name="Student_Name")
    private String name;
    @Column(name="Major")
    private String major;
    @Column(name="Degree")
    private String degree;
    @Column(name="Semester")
    private String semester;
    @Column(name="Course1")
    private String course1;
    @Column(name="Course2")
    private String course2;
    @Column(name="Course3")
    private String course3;

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }
}
