package com.payroll.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.sample.Entity.PaySlip;
import com.payroll.sample.Entity.User;
import com.payroll.sample.Service.AdminService;
import com.payroll.sample.Service.PaySlipServices;
import com.payroll.sample.Service.UserService;
import com.payroll.sample.exception.PaySlipNotFoundException;

@RestController
public class Controller {

	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;

	@Autowired
	PaySlipServices payslipServices;

	@Autowired
	AdminService adminService2;

	// UserManangement
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		return userService.saveMyUser(user);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public List<User> deleteUserById(@PathVariable int id) {
		return userService.deleteUserById(id);
	}

	@PutMapping("UpdateUserById/{id}")
	public List<User> updateUserById(@PathVariable int id, @RequestBody User user) {

		return userService.updateUser(user);
	}

	@GetMapping("findUserByEmailId/{emailId}")
	public User findUserByEmailId(@PathVariable String emailId) {

		return userService.findUserByEmailId(emailId);
	}

	// Payslip
	@PostMapping("/generatePayslip")
	public List<PaySlip> generatePayslipWithId(@RequestParam int id, @RequestParam int deduction,
			@RequestParam String month, @RequestParam String year) throws Exception {

		return payslipServices.generatePayslipWithId(id, deduction, month, year);

	}

	@GetMapping("/findPayslipById/{id}")
	public Optional<PaySlip> findPayslipById(@RequestParam int id) throws PaySlipNotFoundException {

		return payslipServices.findPayslipById(id);

	}

	@GetMapping("/findPayslipByEmailId/{mailId}")
	public PaySlip findPayslipByEmailId(@RequestParam String mailId) throws PaySlipNotFoundException {

		return payslipServices.findPayslipByEmailId(mailId);

	}

	// Admin
	@GetMapping("/CheckWeatherMailIdHasUserAcessOrNot")
	public String CheckWeatherMailIdHasUserAcessOrNot(@RequestParam String email) {
		return adminService.CheckWeatherMailIdHasUserAcessOrNot(email);
	}

}
