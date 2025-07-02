package com.AOA.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOA.entities.Student;
import com.AOA.repository.StudentRepository;
import com.AOA.services.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
