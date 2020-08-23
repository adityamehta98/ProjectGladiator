package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

// account table -> 
//acc_number, acc_type, acc_bank_name, acc_ifsc, salary, existing_emi, user_employment_type, monthly_savings
@Entity

public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4068356449088660689L;

	@OneToOne
    private User user;
	
	@Column(name = "acc_number")
	private int accnumber;
	
	@Column(name = "acc_type")
	private String acctype;
	
	@Column(name = "acc_bank_name")
	private String accbankname;
	
	@Column(name = "acc_ifsc")
	private String accifsc;
	
	@Column(name = "accnumber")
	private int salary;
	
	@Column(name = "existing_emi")
	private int exisitingemi;
	
	@Column(name = "user_employment_type")
	private String useremploymenttype;
	
	@Column(name = "monthly_savings")
	private int monthlysavings;
	
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

	public int getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(int accnumber) {
		this.accnumber = accnumber;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getAccbankname() {
		return accbankname;
	}

	public void setAccbankname(String accbankname) {
		this.accbankname = accbankname;
	}

	public String getAccifsc() {
		return accifsc;
	}

	public void setAccifsc(String accifsc) {
		this.accifsc = accifsc;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExisitingemi() {
		return exisitingemi;
	}

	public void setExisitingemi(int exisitingemi) {
		this.exisitingemi = exisitingemi;
	}

	public String getUseremploymenttype() {
		return useremploymenttype;
	}

	public void setUseremploymenttype(String useremploymenttype) {
		this.useremploymenttype = useremploymenttype;
	}

	public int getMonthlysavings() {
		return monthlysavings;
	}

	public void setMonthlysavings(int monthlysavings) {
		this.monthlysavings = monthlysavings;
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
		return "Account [acc_number=" + accnumber + ", acc_type=" + acctype
				+ ", acc_bank_name=" + accbankname + ", acc_ifsc=" + accifsc + ", salary=" + salary
				+ ", exisiting_emi=" + exisitingemi + ", user_emploment_type=" + useremploymenttype
				+ ", monthly_savings=" + monthlysavings + ", loan=" + loan + ", vehicle=" + vehicle + ",]";
	}

}