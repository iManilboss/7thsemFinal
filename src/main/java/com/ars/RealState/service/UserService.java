package com.ars.RealState.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ars.RealState.model.UserDetail;

public interface UserService {
	public void saveUserDetail(UserDetail userDetail);
	public UserDetail getUserDetailByUsername(String name);
	public List<UserDetail> getUserByRole(String string);
	public UserDetail getUserDetailById(int aid);
	List<UserDetail> getAllItems(String role);

}
