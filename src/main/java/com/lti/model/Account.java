package com.lti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACC_NUMBER", length=30)
	private String accNumber;

	@Column(name="ACC_BANK_NAME", length=30)
	private String accBankName;

	@Column(name="ACC_IFSC", length=30)
	private String accIfsc;

	@Column(name="ACC_TYPE", length=30)
	private String accType;

	@Column(name="EXISITING_EMI")
	private BigDecimal exisitingEmi;

	@Column(name="MONTHLY_SAVINGS")
	private BigDecimal monthlySavings;

	@Column(name="Salary")
	private BigDecimal salary;

	@Column(name="USER_EMPLOYMENT_TYPE", length=30)
	private String userEmploymentType;

	//bi-directional many-to-one association to Loan
	@ManyToOne
	@JoinColumn(name="LOAN_ID")
	private Loan loan;

	//bi-directional many-to-one association to UserTable
	@OneToMany(mappedBy="account")
	private List<UserTable> userTables;

	public Account() {
	}

	public String getAccNumber() {
		return this.accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccBankName() {
		return this.accBankName;
	}

	public void setAccBankName(String accBankName) {
		this.accBankName = accBankName;
	}

	public String getAccIfsc() {
		return this.accIfsc;
	}

	public void setAccIfsc(String accIfsc) {
		this.accIfsc = accIfsc;
	}

	public String getAccType() {
		return this.accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public BigDecimal getExisitingEmi() {
		return this.exisitingEmi;
	}

	public void setExisitingEmi(BigDecimal exisitingEmi) {
		this.exisitingEmi = exisitingEmi;
	}

	public BigDecimal getMonthlySavings() {
		return this.monthlySavings;
	}

	public void setMonthlySavings(BigDecimal monthlySavings) {
		this.monthlySavings = monthlySavings;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getUserEmploymentType() {
		return this.userEmploymentType;
	}

	public void setUserEmploymentType(String userEmploymentType) {
		this.userEmploymentType = userEmploymentType;
	}

	public Loan getLoan() {
		return this.loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public List<UserTable> getUserTables() {
		return this.userTables;
	}

	public void setUserTables(List<UserTable> userTables) {
		this.userTables = userTables;
	}

	public UserTable addUserTable(UserTable userTable) {
		getUserTables().add(userTable);
		userTable.setAccount(this);

		return userTable;
	}

	public UserTable removeUserTable(UserTable userTable) {
		getUserTables().remove(userTable);
		userTable.setAccount(null);

		return userTable;
	}

}