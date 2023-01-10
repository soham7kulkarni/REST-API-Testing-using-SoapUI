package com.example.controller;

import com.example.Repo.StudentRepo;
import com.example.model.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@ComponentScan(basePackages = "com.example.Repo")
public class StudentController {

@Autowired
    StudentRepo st_repo;

    @GetMapping("Students")
    public List<Student> getStudents()
    {
        return st_repo.findAll();
    }


    @GetMapping("Students/{StudentId}")
    public Optional<Student> getStudent(@PathVariable int StudentId) {
        return st_repo.findById(StudentId);
    }

    @GetMapping("Students/Name/{StudentName}")
    public List<Student> getStudentByStudentName(@PathVariable String StudentName) {
        return st_repo.findByname(StudentName);
    }

    @GetMapping("Students/Major/{Major}")
    public List<Student> getStudentByMajor(@PathVariable String Major) {
        return st_repo.findBymajor(Major);
    }


    @GetMapping("Students/Degree/{Degree}")
    public List<Student> getStudentByDegree(@PathVariable String Degree) {
        return st_repo.findBydegree(Degree);
    }

    @GetMapping("Students/Semester/{Semester}")
    public List<Student> getStudentBySemester(@PathVariable String Semester) {
        return st_repo.findBysemester(Semester);
    }

    @GetMapping("Students/Course/{Course}")
    public List<Student> getStudentByCourse(@PathVariable String Course) {
        return st_repo.findBycourse(Course);
    }

    @PostMapping("Students")
    public Student Addstudent(@RequestBody Student Stud)
    {
        System.out.println(st_repo.save(Stud));
        return Stud;
    }

    @DeleteMapping("Students/{StudentId}")
    @ResponseBody
    public String Delstudent(@PathVariable int StudentId)
    {
        try {
            Student s = st_repo.getReferenceById(StudentId);
            System.out.println("printing"+s.getStudent_ID() +s.getName()+s.getDegree());
            if(s.getStudent_ID()==0)
            {
                return "Id not found";
            }
            st_repo.delete(s);
            return "deleted";
        }
        catch (EntityNotFoundException e)
        {
            return "Id not found";
        }
    }

    @PutMapping("Students")
    public Student Updatestudent(@RequestBody Student Stud)
    {
        st_repo.save(Stud);
        return Stud;
    }

}
