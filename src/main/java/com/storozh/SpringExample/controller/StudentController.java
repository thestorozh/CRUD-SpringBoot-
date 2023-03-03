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
        Student student = studentService.createStudent(studentDTO);
        StudentDTO studentResponseDTO = new StudentDTO(student.getId(),student.getFirstname(), student.getLastname(), student.getMiddlename());
        return studentResponseDTO;
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
        StudentDTO studentResponseDTO = new StudentDTO(student.getId(),student.getFirstname(), student.getLastname(), student.getMiddlename());
        return studentResponseDTO;
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