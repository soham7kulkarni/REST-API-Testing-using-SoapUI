package com.example.Repo;

import com.example.controller.FacultyController;
import com.example.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Integer> {

    @Query(value="select * from Faculty f where f.faculty_Name=:Faculty_Name",nativeQuery = true)
    List<Faculty> findByFaculty_Name(@Param("Faculty_Name") String Faculty_Name);
    List<Faculty>  findBydepartment(String Department);
    List<Faculty>  findBycourse(String Course);

     /*
    @Query(value="select faculty_ID,faculty_Name,office_room_no from Faculty f where (f.faculty_Name=:Input) || (f.faculty_ID=:Input)",nativeQuery = true)
    List<Faculty> findRoom(@Param("Input") String Input);  */

}
