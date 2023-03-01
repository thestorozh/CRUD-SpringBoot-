package com.storozh.SpringExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.storozh.SpringExample.DTO.StudentDTO;
import com.storozh.SpringExample.model.Student;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.storozh.SpringExample.service.StudentService;

@RestController
@RequestMapping(value="/api/student")
public class StudentController {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @PostMapping
    public String create(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
        LOG.info("Student is created");
        return "Student is created";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        LOG.info("Retrieved all students");
        return students;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentService.updateStudent(student, studentDTO);
            LOG.info("Updated student with ID {}", student.getId());
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isPresent()) {
            studentService.deleteStudent(optionalStudent.get());
            LOG.info("Student with ID {} deleted successfully", id);
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
        } else {
            LOG.info("Student with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }
}


