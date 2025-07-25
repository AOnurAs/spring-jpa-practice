package com.AOA.entities;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name", nullable = false, length = 40)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(name = "birth_of_date", nullable = true)
	private Date birthOfDate;
	
	@ManyToMany
	@JoinTable(name = "student_course", 
	joinColumns = @JoinColumn(name = "student_id"),
	inverseJoinColumns =  @JoinColumn(name = "course_id"))
	private List<Course> courses;

}
