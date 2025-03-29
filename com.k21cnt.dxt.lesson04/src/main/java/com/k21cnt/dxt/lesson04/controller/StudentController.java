package com.k21cnt.dxt.lesson04.controller;


import com.k21cnt.dxt.lesson04.entity.Student;
import com.k21cnt.dxt.lesson04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student-list")
    public List<Student> getAllStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id){
        Long param = Long.parseLong(id);
        return  studentService.getStudent(param);
    }
    @PostMapping("/student-add")
    public Student addStudent (@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable String id,@RequestBody Student student){
        Long param = Long.parseLong(id);
        return studentService.updateStudent(param,student);
    }
    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable String id){
        Long param = Long.parseLong(id);
        return studentService.deleteStudent(param);
    }
}

