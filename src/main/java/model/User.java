package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.lang.NonNull;

@Entity
public class User implements Serializable{
//	user_id, personal info (name, age, gender, address, etc), user_type(existing / new applicant), email, password
//	for existing user -> all columns will be filled
//	for new applicants -> only id, user_type, email, password
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Id_Gen")
	@Column(name="userid")
	@NonNull
	private int userid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="dob")
	private Date dob ;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private Number zip;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private Set<Account> account;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private Set<Loan> loan;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private Set<Vehicle> vehicle;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Number getZip() {
		return zip;
	}

	public void setZip(Number zip) {
		this.zip = zip;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}