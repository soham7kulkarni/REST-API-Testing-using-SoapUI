package com.example.Repo;

import com.example.model.Faculty;
import com.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    List<Student> findByname(String Student_Name);
    List<Student> findBymajor(String Major);
    List<Student> findBydegree(String Degree);
    List<Student> findBysemester(String Semester);
    @Query(value="select * from Student s where (s.course1=:Course_Name) || (s.course2=:Course_Name) || (s.course3=:Course_Name) ",nativeQuery = true)
    List<Student> findBycourse(@Param("Course_Name") String Course_Name);


}

