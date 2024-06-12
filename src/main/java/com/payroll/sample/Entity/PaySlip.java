package com.payroll.sample.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="payslip")
public class PaySlip {
	
	@Id
	private int id;
	private String email;
	private String month;
	private String year;
	private int deduction;
	
	

}
