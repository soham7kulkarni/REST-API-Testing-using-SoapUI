package com.example.controller;

import com.example.Repo.FacultyRepo;
import com.example.model.Faculty;
import com.example.model.Student;
import jakarta.persistence.Column;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FacultyController {

    @Autowired
    private FacultyRepo f_repo;

    @GetMapping("Faculty")
    public List<Faculty> GetFaculty() {
        System.out.println("Printing"+"    " +f_repo.findAll());
        return f_repo.findAll();


    }

    @GetMapping("Faculty/{FacultyId}")
    public Optional<Faculty> GetFacultyById(@PathVariable int FacultyId) {
        return f_repo.findById(FacultyId);
    }

    @GetMapping("Faculty/FacultyName/{FacultyName}")
    public List<Faculty> GetFacultyByFacultyName(@PathVariable String FacultyName) {
         return f_repo.findByFaculty_Name(FacultyName);
    }

    @GetMapping("Faculty/FacultyByDep/{Department}")
    public List<Faculty> GetFacultyByDepartment(@PathVariable String Department) {
        return f_repo.findBydepartment(Department);
    }

    @GetMapping("Faculty/FacultyByCourse/{Course}")
    public List<Faculty> GetFacultyByCourse(@PathVariable String Course) {
       return f_repo.findBycourse(Course);
    }

    @PostMapping("Faculty")
    public Faculty Addfaculty(@RequestBody Faculty Facu)
    {
        f_repo.save(Facu);
        return Facu;
    }

    @DeleteMapping("Faculty/{FacultyId}")
    @ResponseBody
    public String Delfaculty(@PathVariable int FacultyId)
    {
        try {
            Faculty f = f_repo.getReferenceById(FacultyId);
            System.out.println("Printing"+f.getFaculty_ID()+" "+f.getFaculty_Name());
            if(f.getFaculty_ID()==0)
            {
                return "Id not found";
            }
            f_repo.delete(f);
            return "deleted";
        }
        catch (EntityNotFoundException e)
        {
            return "Id not found";
        }

    }

    @PutMapping("Faculty")
    public Faculty Updatefaculty(@RequestBody Faculty Facu)
    {
        f_repo.save(Facu);
        return Facu;
    }
/*
    public class Room{

        private int faculty_ID;

        private String faculty_Name;

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

        public String getOffice_room_no() {
            return office_room_no;
        }

        public void setOffice_room_no(String office_room_no) {
            this.office_room_no = office_room_no;
        }
    }

    @GetMapping("Facultyroom/{Input}")
    public List<Room> GetFacultyRoom(@PathVariable String Input) {
        return  f_repo.findRoom(Input);
    }
*/
@GetMapping("Facultyroom/{Id}")
public String GetFacultyRoom(@PathVariable int Id) {
    Optional<Faculty> f= f_repo.findById(Id);
     if(f.isEmpty()==false){return f.get().getOffice_room_no();}
     else{return "Entered Id is incorrect";}
}

}
