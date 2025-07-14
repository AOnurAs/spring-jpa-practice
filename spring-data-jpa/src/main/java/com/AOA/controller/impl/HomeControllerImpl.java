package com.AOA.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AOA.controller.IHomeController;
import com.AOA.dto.DtoHome;
import com.AOA.services.IHomeService;

@RestController
@RequestMapping("rest/api/home")
public class HomeControllerImpl implements IHomeController {

	@Autowired
	private IHomeService homeService;
	
	@GetMapping(path = "/{id}")
	@Override
	public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
		
		return homeService.findDtoHomeById(id);
	}
	
}
