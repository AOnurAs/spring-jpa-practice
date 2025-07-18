package com.AOA.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
 
	private List<DtoCourse> courses = new ArrayList<>();
}
