package com.AOA.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AOA.controller.IStudentController;
import com.AOA.entities.Student;
import com.AOA.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {
		System.out.println("/save\t" + student.toString());
		return studentService.saveStudent(student);
	}

}
