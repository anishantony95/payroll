package com.payroll.sample.Repo;

import org.springframework.data.repository.CrudRepository;

import com.payroll.sample.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByEmail(String email);

}
