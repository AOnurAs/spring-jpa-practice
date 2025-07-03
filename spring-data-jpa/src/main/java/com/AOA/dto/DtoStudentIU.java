package com.AOA.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU { // IU insert-update

	private String firstName;
	
	private String lastName;

	@JsonFormat(pattern="dd-MM-yyyy")
	private Date birthOfDate;
	
}
