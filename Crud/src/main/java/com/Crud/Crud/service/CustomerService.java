package com.Crud.Crud.service;

import com.Crud.Crud.entitiy.Customer;
import com.Crud.Crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	public List<Customer> findAllCustomer()
	{
		return customerRepository.findAll();
	}
	public Customer getCustomerById(Long customerId)
	{
		return customerRepository.findById(customerId).get();
	}
	public void deleteCustomerById(Long customerId)
	{
		customerRepository.deleteById(customerId);
	}
}