package com.bitee.StudentManagement.controllers;


import com.bitee.StudentManagement.models.Student;
import com.bitee.StudentManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getSingleStudent(@PathVariable("id") Long id){
        return this.studentService.getSingleStudent(id);
    }
    @PostMapping
    public void createStudent(@RequestBody Student student){
           this.studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required =false) String email,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) LocalDate dob
                              ){
        this.studentService.updateStudent(id,email,name,dob);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        this.studentService.deleteStudent(id);
    }
}
