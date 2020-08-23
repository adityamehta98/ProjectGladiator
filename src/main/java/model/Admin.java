package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Admin {
//	admin table -> admin_id, admin_name, admin_email, admin_pass
	@Id
	@Column(name="admin_id")
	@NonNull
	private int adminid;
	
	@Column(name="admin_name")
	private String name;
	
	@Column(name="admin_email")
	private String email;
	
	@Column(name="admin_password")
	private String password;
	
	public Admin() {}

	@Override
	public String toString() {
		return "User [Adminid=" + adminid + ", Name=" + name + ", Password=" + password + ", Email=" + email + ",]";
	}
}