package com.AOA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AOA.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
