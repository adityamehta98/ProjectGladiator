package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.controller.ControllerClass.Status.StatusType;
import com.lti.Dto.*;
import com.lti.model.UserTable;
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