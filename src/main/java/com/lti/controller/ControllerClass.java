package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.ControllerClass.Status.StatusType;
import com.lti.Dto.*;
import com.lti.model.*;
import com.lti.exception.CustomerServiceException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class ControllerClass {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Status register(@RequestBody UserTable user) 
	{
		try 
		{
			userService.register(user);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful");
			return status;
		}
		
		catch (CustomerServiceException e) 
		{
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
	@PostMapping("/loginuser")
	public LoginStatus login(@RequestBody LoginDto loginDto) {
		try {
			UserTable user = userService.login(loginDto.getEmail(), loginDto.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.SUCCESS);
			loginStatus.setMessage("Login Successful");
			loginStatus.setUserId(user.getUserId());
			loginStatus.setUserNameFirst(user.getUserNameFirst());
			return loginStatus;
		}
		catch(CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(StatusType.FAILURE);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}
	
	@PostMapping("/loginadmin")
	public LoginAdminStatus loginadmin(@RequestBody AdminLoginDto adminloginDto) {
		try {
			Admin admin = userService.loginadmin(adminloginDto.getEmail(),adminloginDto.getPassword());
			LoginAdminStatus loginAdminStatus = new LoginAdminStatus();
			loginAdminStatus.setStatus(StatusType.SUCCESS);
			loginAdminStatus.setMessage("Login Successful");
			loginAdminStatus.setAdminId(admin.getAdminId());
			loginAdminStatus.setAdminNameFirst(admin.getAdminNameFirst());
			return loginAdminStatus;
		}
		catch(CustomerServiceException e) {
			LoginAdminStatus loginAdminStatus = new LoginAdminStatus();
			loginAdminStatus.setStatus(StatusType.FAILURE);
			loginAdminStatus.setMessage(e.getMessage());
			return loginAdminStatus;
		}
	}
	
	@PostMapping("/registeraccount")
	public Status registerAccount(@RequestBody Account account) 
	{
		try 
		{
			userService.registerAccount(account);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Account Registration Successful");
			return status;
		}
		
		catch (CustomerServiceException e) 
		{
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/vehicleregister")
	public Status registerVehicle(@RequestBody Vehicle vehicle) 
	{
		try {
			userService.registerVehicle(vehicle);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successful");
			return status;
		}
		
		catch (CustomerServiceException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/registerloan")
	public Status registerloan(@RequestBody Loan loan) 
	{
		try 
		{
			userService.registerLoan(loan);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Loan Registration Successful");
			return status;
		}
		
		catch (CustomerServiceException e) 
		{
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping("/viewallusers")
	public List<UserTable> viewAllUsers() 
	{	
		return userService.viewAllUsers();

	}
	
	@GetMapping("/viewrejectedusers")
	public List<Loan> viewRejectedUsers() 
	{	
		return userService.viewRejectedUsers();

	}
	
	@GetMapping("/viewapprovedusers")
	public List<Loan> viewApprovedUsers() 
	{	
		return userService.viewApprovedUsers();

	}
	
	@GetMapping("/viewpendingusers")
	public List<Loan> viewPendingUsers() 
	{	
		return userService.viewPendingUsers();

	}
	
//	@GetMapping("/viewrejectedusers")
//	public List<UserTable> viewRejectedUsers() 
//	{	
//		return userService.viewRejectedUsers();
//
//	}
//	
//	@GetMapping("/viewapprovedusers")
//	public List<UserTable> viewApprovedUsers() 
//	{	
//		return userService.viewApprovedUsers();
//
//	}
//	
//	@GetMapping("/viewpendingusers")
//	public List<UserTable> viewPendingUsers() 
//	{	
//		return userService.viewPendingUsers();
//
//	}
	
	@PostMapping("/rejectloan")
	public Status rejectLoan(@RequestBody long loanId) 
	{
		try 
		{
			userService.rejectLoan(loanId);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Loan Rejected");
			return status;
		}
		
		catch (CustomerServiceException e) 
		{
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/approveLoan")
	public Status register(@RequestBody long loanId) 
	{
		try 
		{
			userService.approveLoan(loanId);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Loan Approved");
			return status;
		}
		
		catch (CustomerServiceException e) 
		{
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
		public static class LoginStatus extends Status {
			private long userId;
			private String name;
			
			public long getuserId() {
				return userId;
			}
			public void setUserId(long userId) {
				this.userId = userId;
			}
			public String getUserNameFirst() {
				return name;
			}
			public void setUserNameFirst(String name) {
				this.name = name;
			}
		}
		
		public static class LoginAdminStatus extends Status {
			private long adminId;
			private String adminName;
			
			public long getadminId() {
				return adminId;
			}
			public void setAdminId(long adminId) {
				this.adminId = adminId;
			}
			public String getAdminNameFirst() {
				return adminName;
			}
			public void setAdminNameFirst(String adminName) {
				this.adminName = adminName;
			}
		}
	
	
	public static class Status {
		
		private StatusType status;
		private String message;
		
		public static enum StatusType {
			SUCCESS,FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		
	}
}