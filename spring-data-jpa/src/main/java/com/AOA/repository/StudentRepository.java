package com.AOA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AOA.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
