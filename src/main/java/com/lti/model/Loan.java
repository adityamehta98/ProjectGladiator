package com.lti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the LOAN database table.
 * 
 */
@Entity
@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "Loan_Id_Seq", sequenceName = "Loan_Id_Seq", allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Loan_Id_Seq")
	@Column(name="LOAN_ID")
	private long loanId;

	@Column(name="APPLICATION_STATUS", length=30)
	private String applicationStatus;

	@Column(name="EMI")
	private float emi;

	@Column(name="INTEREST_RATE")
	private float interestRate;

	@Column(name="LOAN_AMOUNT")
	private float loanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="LOAN_END_DATE")
	private Date loanEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="LOAN_START_DATE")
	private Date loanStartDate;

	@Column(name="LOAN_STATUS", length=30)
	private String loanStatus;

	@Column(name="PROCESSING_FEE")
	private float processingFee;
	
	@Column(name="TENURE")
	private float tenure;

	@Column(name="LOAN_TYPE", length=30)
	private String loantype;
	
	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="loan")
	private List<Account> accounts;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;

	//bi-directional many-to-one association to UserTable
	@OneToMany(mappedBy="loan")
	private List<UserTable> userTables;
   

	public Loan() {
	}

	public long getLoanId() {
		return this.loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getApplicationStatus() {
		return this.applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public float getEmi() {
		return this.emi;
	}

	public void setEmi(float emi) {
		this.emi = emi;
	}

	public float getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanEndDate() {
		return this.loanEndDate;
	}

	public void setLoanEndDate(Date loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	public Date getLoanStartDate() {
		return this.loanStartDate;
	}

	public void setLoanStartDate(Date loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public String getLoanStatus() {
		return this.loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public float getProcessingFee() {
		return this.processingFee;
	}

	public void setProcessingFee(float processingFee) {
		this.processingFee = processingFee;
	}

	public float getTenure() {
		return this.tenure;
	}

	public void setTenure(float tenure) {
		this.tenure = tenure;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setLoan(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setLoan(null);

		return account;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<UserTable> getUserTables() {
		return this.userTables;
	}

	public void setUserTables(List<UserTable> userTables) {
		this.userTables = userTables;
	}

	public UserTable addUserTable(UserTable userTable) {
		getUserTables().add(userTable);
		userTable.setLoan(this);

		return userTable;
	}

	public UserTable removeUserTable(UserTable userTable) {
		getUserTables().remove(userTable);
		userTable.setLoan(null);

		return userTable;
	}

	public String getLoantype() {
		return loantype;
	}

	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}

}