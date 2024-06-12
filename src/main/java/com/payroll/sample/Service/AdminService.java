package com.payroll.sample.Service;

import org.springframework.stereotype.Service;

import com.payroll.sample.Entity.Admin;
import com.payroll.sample.Repo.AdminRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService {

	private final AdminRepo adminRepository;

	public AdminService(AdminRepo adminRepository) {
		this.adminRepository = adminRepository;
	}

	public String CheckWeatherMailIdHasUserAcessOrNot(String email) {

		for (Admin admin : adminRepository.findAll()) {
			if (admin.getEmail().equals(email))
				return email + " Has User Acess";

		}
		return "Email Id Does Not has User Acess";

	}
}
