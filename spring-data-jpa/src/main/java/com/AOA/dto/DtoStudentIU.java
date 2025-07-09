package com.AOA.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU { // IU insert-update

	@NotEmpty(message = "First Name cannot be empty or null")
	@Size(min = 3, max = 10)
	private String firstName;
	
	@Size(min = 3, max = 30)
	private String lastName;

	@JsonFormat(pattern="dd-MM-yyyy")
	private Date birthOfDate;
	
	//@Email(message = "Wrong email format")
	//private String Email
	
	//@Size(min = 11, max = 11, message = "Tckn should be 11 characters")
	//@NotEmpty(message = "Tckn cannot be empty or null")
	//private String tckn
	
}
