package com.payroll.sample.Repo;

import org.springframework.data.repository.CrudRepository;

import com.payroll.sample.Entity.Admin;


public interface AdminRepo extends CrudRepository<Admin, Integer> {

	public Admin findByEmailAndPassword(String email, String password);

	
}
