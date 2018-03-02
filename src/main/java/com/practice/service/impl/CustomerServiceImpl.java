package com.practice.service.impl;

import com.practice.entity.Customer;
import com.practice.service.CustomerService;
import com.practice.repository.CustomerRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public int saveCustomer(Customer customer) {
		customerRepository.save(customer);
		return 1;
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		if(customer != null && customer.getId() != null) {
			Customer existingCustomer = customerRepository.findOne(customer.getId());
			existingCustomer.setName(customer.getName());
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setPhoneNumber(customer.getPhoneNumber());
			customerRepository.save(existingCustomer);
		}

	}

	@Override
	@Transactional
	public void deleteCustomer(String customerName) {
		if(customerName != null) {
			//Customer existingCustomer = customerRepository.findOne(customerId);
			LOGGER.info("Deleting the customer with name {}", customerName);
			customerRepository.deleteCustomersByName(customerName);
			LOGGER.info("Successfully deleted the customer with name {}", customerName);
		}

	}

	@Override
	public List<Customer> findCustomersByName(String customerName) {
		return customerRepository.findCustomersByName(customerName);
	}
	
	@Override
	@Transactional
	public List<Customer> searchCustomer(String customerName) {
		List<Customer> customers = new ArrayList<Customer>();
		if(customerName != null) {
			customers = customerRepository.findCustomersByName(customerName);
			LOGGER.info("Search the customers with name  like {}", customerName);
			
			
		}
		return customers;

	}
}

