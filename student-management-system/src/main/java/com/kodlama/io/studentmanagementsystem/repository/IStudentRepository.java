package com.kodlama.io.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlama.io.studentmanagementsystem.entities.Student;
@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
	
	boolean existsByName(String name);
	boolean existsByEmail(String email);

}
