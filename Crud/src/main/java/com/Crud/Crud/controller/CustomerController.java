package com.Crud.Crud.controller;

import com.Crud.Crud.entitiy.Customer;
import com.Crud.Crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer addCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> findAllCustomer()
	{
		List<Customer> allCustomer = customerService.findAllCustomer();
		return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id)
	{
		Customer getCustomerById = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(getCustomerById,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id)
	{
		customerService.deleteCustomerById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
