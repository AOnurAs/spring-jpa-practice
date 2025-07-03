package com.AOA.services;

import java.util.List;

import com.AOA.entities.Student;

import dto.DtoStudent;
import dto.DtoStudentIU;

public interface IStudentService {

	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<	DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent);
}
