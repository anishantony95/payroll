package com.payroll.sample.Repo;

import org.springframework.data.repository.CrudRepository;

import com.payroll.sample.Entity.PaySlip;

public interface PaySlipRepository extends CrudRepository<PaySlip, Integer> {

	public PaySlip findByEmail(String email);
}
