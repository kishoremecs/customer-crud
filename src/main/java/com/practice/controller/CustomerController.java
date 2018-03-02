package com.practice.controller;

import com.practice.entity.Customer;
import com.practice.repository.CustomerRepository;
import com.practice.service.CustomerService;
import com.practice.service.*;
import com.practice.service.impl.*;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping(path="/list", method=RequestMethod.GET, produces="application/json")
	public List<Customer>  listCustomers () {
		//TODO 
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerService.findAllCustomers();
		LOGGER.info("The total Customers size is {}", customers.size());
		return customers;
	}

	@RequestMapping(path="/save/", method=RequestMethod.PUT, consumes="application/json")
	public void createCustomer (@RequestBody Customer customer) {
		//TODO 
		LOGGER.info("Creating the Customer record in DB");
		int count = customerService.saveCustomer(customer);
		//return count;
	}

	@RequestMapping(path="/update/", method=RequestMethod.POST, consumes="application/json")
	public void updateCustomer (@RequestBody Customer customer) {
		List<Customer> existingCustomers = customerService.findCustomersByName(customer.getName());
		if(existingCustomers != null && existingCustomers.size() == 1) {
			customer.setId(existingCustomers.get(0).getId());
			LOGGER.info("Updating the Customer record in DB for the id {}", existingCustomers.get(0).getId());
			customerService.updateCustomer(customer);
		}

	}

	@RequestMapping(path="/delete/{name}", method=RequestMethod.DELETE)
	public void deleteCustomer (@PathVariable("name") String name) {
 
		LOGGER.info("Deletng the Customer record in DB");
		customerService.deleteCustomer(name);

	}

	@RequestMapping(path="/search/{name}", method=RequestMethod.GET, produces="application/json")
	public List<Customer> searchCustomer (@PathVariable("name") String customerName) {
 
		LOGGER.info("Searching the Customer records in DB");
		List<Customer> customers = customerService.searchCustomer(customerName);
		return customers;

	}

	
	
}