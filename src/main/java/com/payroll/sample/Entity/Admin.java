package com.payroll.sample.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="admin")
public class Admin {

	
	@Id
	private int id;
	private String email;
	private String password;
	
	
	
	
}
