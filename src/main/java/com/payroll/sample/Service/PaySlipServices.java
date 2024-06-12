package com.payroll.sample.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.sample.Entity.PaySlip;
import com.payroll.sample.Entity.User;
import com.payroll.sample.Repo.PaySlipRepository;
import com.payroll.sample.exception.PaySlipNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaySlipServices {

	@Autowired
	UserService userService;

	// Constructor injection

	private final PaySlipRepository paySlipRepository;

	public PaySlipServices(PaySlipRepository payRepository) {
		this.paySlipRepository = payRepository;
	}

	public List<PaySlip> generatePayslipWithId(int id, int deduction, String month, String year) throws Exception {

		PaySlip currentPayslip = new PaySlip();
		Optional<User> currentUser = userService.findUserByEmailId(id);
		if (currentUser.isEmpty()) {
			throw new UserPrincipalNotFoundException("Nouser found");
		} else {

			currentPayslip.setDeduction(deduction);
			currentPayslip.setEmail(currentUser.get().getEmail());
			currentPayslip.setId(currentUser.get().getId());
			currentPayslip.setMonth(month);
			currentPayslip.setYear(year);

		}
		paySlipRepository.save(currentPayslip);
		List<PaySlip> AllpaySlip = new ArrayList<PaySlip>();
		for (PaySlip payslip : paySlipRepository.findAll()) {
			AllpaySlip.add(payslip);
		}

		return AllpaySlip;

	}

	// ---------------------------------------------------------

	public void savePayslip(PaySlip payslip) {

		paySlipRepository.save(payslip);
	}

	public PaySlip findByEmail(String email) {
		return paySlipRepository.findByEmail(email);
	}

	public Optional<PaySlip> findPayslipById(int id) throws PaySlipNotFoundException {

		Optional<PaySlip> CurrentPaySlip = paySlipRepository.findById(id);
		if (CurrentPaySlip.isEmpty()) {
			throw new PaySlipNotFoundException("Pay slipNot Found");
		} else {
			return CurrentPaySlip;
		}
	}

	public PaySlip findPayslipByEmailId(String mailId) {

		return paySlipRepository.findByEmail(mailId);
	}

}
