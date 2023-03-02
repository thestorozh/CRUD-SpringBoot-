package com.storozh.SpringExample.service;

import com.storozh.SpringExample.DTO.StudentDTO;	
import com.storozh.SpringExample.model.Student;
import com.storozh.SpringExample.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstname(studentDTO.getFirstname());
        student.setLastname(studentDTO.getLastname());
        student.setMiddlename(studentDTO.getMiddlename());
        studentRepository.save(student);
        LOG.info("Student with ID {} is created", student.getId());
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstname(studentDTO.getFirstname());
            student.setLastname(studentDTO.getLastname());
            student.setMiddlename(studentDTO.getMiddlename());
            studentRepository.save(student);
            LOG.info("Student with ID {} is updated", id);
            return student;
        } else {
            return null;
        }
    }
  
    public boolean deleteStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
            return true;
        } else {
            return false;
        }
    }
}