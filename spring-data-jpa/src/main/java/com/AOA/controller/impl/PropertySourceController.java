package com.AOA.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AOA.configuration.GlobalConfigurationProperties;
import com.AOA.configuration.GlobalProperties;
import com.AOA.configuration.Props;
import com.AOA.dto.DtoProperties;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {
	
	@Autowired
	private GlobalProperties globalProperties;
	
	@Autowired
	private GlobalConfigurationProperties globalConfigurationProperties;
	
	@GetMapping("/datasource")
	public DtoProperties getDataSource(){
		DtoProperties dtoProperties = new DtoProperties();
		dtoProperties.setUrl(globalProperties.getUrl());
		dtoProperties.setUsername(globalProperties.getUsername());
		
		return dtoProperties;
	}
	
	@GetMapping("/props")
	public List<Props> getProps(){
		
		return globalConfigurationProperties.getProp();
	}
	
}
