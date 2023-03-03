package com.storozh.SpringExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.storozh.SpringExample.DTO.StudentDTO;
import com.storozh.SpringExample.model.Student;
import java.util.List;
import com.storozh.SpringExample.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public StudentDTO create(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        return studentDTO;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Student student = studentService.updateStudent(id, studentDTO);
        if (student == null) {
            throw new RuntimeException("Student not found with id " + id);
        }
        return studentDTO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        boolean success = studentService.deleteStudentById(id);
        if (success) {
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }
}