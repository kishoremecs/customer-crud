package com.practice.entity;

import javax.persistence.*;

import lombok.*;

@Entity(name="Customer")
@Table(name="Customer")
@Data
@ToString
public class Customer {

	@Id
	@Column(name="id")
	@SequenceGenerator(name="seq_customer", sequenceName="seq_customer", allocationSize=1)
	@GeneratedValue(generator="seq_customer", strategy=GenerationType.SEQUENCE)
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;
	
	@Column(name="phone_num")
	private String phoneNumber;

}