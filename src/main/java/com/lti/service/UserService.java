package com.lti.service;

import com.lti.model.UserTable;

public interface UserService {

	void register(UserTable user);

	UserTable login(String email, String password);

}