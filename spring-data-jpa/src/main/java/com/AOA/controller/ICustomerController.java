package com.AOA.controller;

import com.AOA.dto.DtoCustomer;

public interface ICustomerController {
	public DtoCustomer findCustomerById(Long id);
}
