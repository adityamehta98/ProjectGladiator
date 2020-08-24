package com.lti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

// account table -> 
//acc_number, acc_type, acc_bank_name, acc_ifsc, salary, existing_emi, user_employment_type, monthly_savings
@Entity
public class Account implements Serializable{

	private static final long serialVersionUID = 4068356449088660689L;

	@OneToOne
    private User user;
	
	@Column(name = "acc_number")
	private int acc_number;
	
	@Column(name = "acc_type")
	private String acc_type;
	
	@Column(name = "acc_bank_name")
	private String acc_bank_name;
	
	@Column(name = "acc_ifsc")
	private String acc_ifsc;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "existing_emi")
	private int exisiting_emi;
	
	@Column(name = "user_employment_type")
	private String user_employment_type;
	
	@Column(name = "monthly_savings")
	private int monthly_savings;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "acc_number", referencedColumnName = "acc_number")
	private Set<Loan> loan;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "acc_number", referencedColumnName = "acc_number")
	private Set<Vehicle> vehicle;

	public Account() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAcc_number() {
		return acc_number;
	}

	public void setAcc_number(int acc_number) {
		this.acc_number = acc_number;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAcc_bank_name() {
		return acc_bank_name;
	}

	public void setAcc_bank_name(String acc_bank_name) {
		this.acc_bank_name = acc_bank_name;
	}

	public String getAcc_ifsc() {
		return acc_ifsc;
	}

	public void setAcc_ifsc(String acc_ifsc) {
		this.acc_ifsc = acc_ifsc;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExisiting_emi() {
		return exisiting_emi;
	}

	public void setExisiting_emi(int exisiting_emi) {
		this.exisiting_emi = exisiting_emi;
	}

	public String getUser_employment_type() {
		return user_employment_type;
	}

	public void setUser_employment_type(String user_employment_type) {
		this.user_employment_type = user_employment_type;
	}

	public int getMonthly_savings() {
		return monthly_savings;
	}

	public void setMonthly_savings(int monthly_savings) {
		this.monthly_savings = monthly_savings;
	}

	public Set<Loan> getLoan() {
		return loan;
	}

	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}

	public Set<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", acc_number=" + acc_number + ", acc_type=" + acc_type + ", acc_bank_name="
				+ acc_bank_name + ", acc_ifsc=" + acc_ifsc + ", salary=" + salary + ", exisiting_emi=" + exisiting_emi
				+ ", user_employment_type=" + user_employment_type + ", monthly_savings=" + monthly_savings + ", loan="
				+ loan + ", vehicle=" + vehicle + "]";
	}

}