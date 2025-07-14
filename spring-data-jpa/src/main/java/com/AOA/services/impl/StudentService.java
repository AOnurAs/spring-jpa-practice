package com.AOA.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOA.dto.DtoCourse;
import com.AOA.dto.DtoStudent;
import com.AOA.dto.DtoStudentIU;
import com.AOA.entities.Course;
import com.AOA.entities.Student;
import com.AOA.repository.StudentRepository;
import com.AOA.services.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
		DtoStudent responseDtoStudent = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudent, student);
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, responseDtoStudent);
		return responseDtoStudent;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		List<DtoStudent> dtoList = new ArrayList<>();
		
		for (Student student : studentList) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}
		return dtoList;
	}

/*	@Override
	public DtoStudent getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		DtoStudent dtoStudent = new DtoStudent();
		if(optional.isPresent()) {
			BeanUtils.copyProperties(optional.get(), dtoStudent);
			return dtoStudent;
		}
		
		return null;
	}	*/

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		
		Student dbStudent = optional.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		
		if(dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
			for (Course course: dbStudent.getCourses()) {
				DtoCourse dtoCourse = new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				
				dtoStudent.getCourses().add(dtoCourse);
			}
		}
		return dtoStudent;
	}


	private Student getDbStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);;
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student dbStudent = getDbStudentById(id);
		if(dbStudent != null) {
			studentRepository.delete(dbStudent);
		}else {
			System.out.println("(DELETE) No records of Stduent with id: " + id + " found!");
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent) {
		Student dbStudent = getDbStudentById(id);
		DtoStudent dtoStudent = new DtoStudent();
		if(dbStudent != null) {
			dbStudent.setFirstName(updateStudent.getFirstName());
			dbStudent.setLastName(updateStudent.getLastName());
			dbStudent.setLastName(updateStudent.getLastName());
			dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
			
			studentRepository.save(dbStudent);
			BeanUtils.copyProperties(dbStudent, dtoStudent);
			return dtoStudent;
		}else {
			System.out.println("(UPDATE) No records of Stduent with id: " + id + " found!");
		}
		return null;
	}

}
