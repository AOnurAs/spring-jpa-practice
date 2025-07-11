package com.AOA.services;

import com.AOA.dto.DtoCustomer;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(Long id);
}
