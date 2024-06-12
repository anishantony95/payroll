package com.payroll.sample.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="mytable")
public class User {
	
	@Id
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String doj;
	private String possition;
	
	private String age;
	private String salary;
	private String password;
	
	

}
