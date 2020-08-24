package com.lti.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan implements Serializable{
	
	private static final long serialVersionUID = 2871439282547949125L;

	public Loan() {	}
	
	@Id
	@GeneratedValue
	@Column(name = "loan_id")
	private int loanId;
	
	@Column(name = "loan_amount")
	private float loanAmount;
	
	@Column(name = "interest_rate")
	private float interestRate;
	
	@Column(name = "processing_fee")
	private float processingFee;
	
	@Column(name = "emi")
	private float emi;
	
	@Column(name = "tenure_in_months")
	private int tenureInMonths;
	
	@Column(name = "application_status")
	private String applicationStatus;
	
	@Column(name = "loan_status")
	private String loanStatus;
	
	
	@Column(name = "loan_starting_date")
	private Date loanStartingDate;
	
	@Column(name = "loan_ending_date")
	private Date loanEndingDate;

	
	@ManyToOne
    private User userid;
	
	@ManyToOne
    private Account accountnumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "loan_id", referencedColumnName = "loan_id")
	private Set<Vehicle> vehicle;

	public int getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}


	public float getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}


	public float getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}


	public float getProcessingFee() {
		return processingFee;
	}


	public void setProcessingFee(float processingFee) {
		this.processingFee = processingFee;
	}


	public float getEmi() {
		return emi;
	}


	public void setEmi(float emi) {
		this.emi = emi;
	}


	public int getTenureInMonths() {
		return tenureInMonths;
	}


	public void setTenureInMonths(int tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	public String getLoanStatus() {
		return loanStatus;
	}


	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}


	public Date getLoanStartingDate() {
		return loanStartingDate;
	}


	public void setLoanStartingDate(Date loanStartingDate) {
		this.loanStartingDate = loanStartingDate;
	}


	public Date getLoanEndingDate() {
		return loanEndingDate;
	}


	public void setLoanEndingDate(Date loanEndingDate) {
		this.loanEndingDate = loanEndingDate;
	}

	public Set<Vehicle> getVehicle() {
		return vehicle;
	}


	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}


	public User getUserid() {
		return userid;
	}
	
	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Account getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(Account accountnumber) {
		this.accountnumber = accountnumber;
	}
	
}

