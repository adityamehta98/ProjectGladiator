package com.lti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "ADMIN" database table.
 * 
 */
@Entity
@Table(name="ADMIN")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADMIN_ID")
	private long adminId;

	@Column(name="ADMIN_AGE")
	private BigDecimal adminAge;

	@Column(name="ADMIN_EMAIL", length=30)
	private String adminEmail;

	@Column(name="ADMIN_GENDER", length=30)
	private String adminGender;

	@Column(name="ADMIN_NAME_FIRST", length=30)
	private String adminNameFirst;

	@Column(name="ADMIN_NAME_LAST", length=30)
	private String adminNameLast;

	@Column(name="ADMIN_PASS", length=30)
	private String adminPass;

	public Admin() {
	}

	public long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public BigDecimal getAdminAge() {
		return this.adminAge;
	}

	public void setAdminAge(BigDecimal adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminEmail() {
		return this.adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminGender() {
		return this.adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getAdminNameFirst() {
		return this.adminNameFirst;
	}

	public void setAdminNameFirst(String adminNameFirst) {
		this.adminNameFirst = adminNameFirst;
	}

	public String getAdminNameLast() {
		return this.adminNameLast;
	}

	public void setAdminNameLast(String adminNameLast) {
		this.adminNameLast = adminNameLast;
	}

	public String getAdminPass() {
		return this.adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

}