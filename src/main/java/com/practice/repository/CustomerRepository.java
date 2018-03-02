package com.practice.repository;

import com.practice.entity.Customer;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c where c.name like %?1%")
	List<Customer> findCustomersByName(String customerName);

	@Modifying
	@Query("delete from Customer c where c.name = ?1")
	void deleteCustomersByName(String customerName);

}