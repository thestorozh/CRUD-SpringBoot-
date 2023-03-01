package com.storozh.SpringExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.storozh.SpringExample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	Optional<Student> findById(Long id);

	}