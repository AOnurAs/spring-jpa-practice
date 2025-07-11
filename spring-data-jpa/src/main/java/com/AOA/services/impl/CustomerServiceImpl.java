package com.AOA.services.impl;

import java.lang.foreign.AddressLayout;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AOA.dto.DtoAddress;
import com.AOA.dto.DtoCustomer;
import com.AOA.entities.Address;
import com.AOA.entities.Customer;
import com.AOA.repository.ICustomerRepository;
import com.AOA.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(Long id) {
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		Optional<Customer> optional = customerRepository.findById(id);

		if (optional.isEmpty()) {
			return null;
		}
		
		Customer customer = optional.get();
		Address address = optional.get().getAddress();

		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;
	}

}
