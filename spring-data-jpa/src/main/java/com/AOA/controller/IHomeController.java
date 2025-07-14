package com.AOA.controller;

import com.AOA.dto.DtoHome;

public interface IHomeController {
	
	public DtoHome findHomeById(Long id);
}
