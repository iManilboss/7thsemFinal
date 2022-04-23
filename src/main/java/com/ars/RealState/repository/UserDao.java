package com.ars.RealState.repository;

import java.util.List;

import com.ars.RealState.model.UserDetail;
import com.ars.RealState.model.UserRole;

public interface UserDao {
	public void insert(UserDetail ud);


	public List<UserDetail> selectByUserRole(String role);

	public UserDetail selectById(int aid);

	public UserDetail selectByUsername(String uname);
	
public List<UserDetail> selectByrole(String role);
	
	public void update(UserDetail userdetail);
	public void delete(UserDetail userdetail,UserRole userrole);
	
}
