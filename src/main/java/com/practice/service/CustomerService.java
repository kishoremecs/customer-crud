package com.practice.service;

import com.practice.entity.Customer;

import java.util.List;

/**
 *
 * Created By Kishore 3/1/2018
 */
public interface CustomerService {

	List<Customer> findAllCustomers();
	int saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(String customerName);
	List<Customer> searchCustomer (String customerName);
	List<Customer> findCustomersByName(String customerName);
}