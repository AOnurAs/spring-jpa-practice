package com.AOA.services.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);;
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student dbStudent = getStudentById(id);
		if(dbStudent != null) {
			studentRepository.delete(dbStudent);
		}else {
			System.out.println("(DELETE) No records of Stduent with id: " + id + " found!");
		}
	}

	@Override
	public Student updateStudent(Integer id, Student updateStudent) {
		Student dbStudent = getStudentById(id);
		if(dbStudent != null) {
			dbStudent.setFirstName(updateStudent.getFirstName());
			dbStudent.setLastName(updateStudent.getLastName());
			dbStudent.setLastName(updateStudent.getLastName());
			dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
			
			studentRepository.save(dbStudent);
		}else {
			System.out.println("(UPDATE) No records of Stduent with id: " + id + " found!");
		}
		return null;
	}

}
