package com.ars.RealState.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ars.RealState.model.UserDetail;
import com.ars.RealState.model.UserRole;
import com.ars.RealState.repository.UserDao;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDao userDao;
	public void saveUserDetail(UserDetail userDetail) {
		userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
		
		if(userDetail.getAuthority().equals("ADMIN")) {
			userDetail.setActive("0"); //user is deactivated
		}else {
			userDetail.setActive("1");//other user are activated as soon as they signup
		}
		userDao.insert(userDetail);
	}
	public UserDetail getUserDetailByUsername(String name) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(name);
	}
	public List<UserDetail> getUserByRole(String role) {
		// TODO Auto-generated method stub
		return userDao.selectByUserRole(role);
	}
	public UserDetail getUserDetailById(int aid) {
		// TODO Auto-generated method stub
		return userDao.selectById(aid);
	}
	public List<UserDetail> getAllItems(String role) {
		// TODO Auto-generated method stub
		return userDao.selectByrole(role);
	}
	public void deleteUser(int id) {
		UserDetail userdetail = new UserDetail();
		userdetail.setId(id);
		
		UserRole userrole = new UserRole();
		int id1= id+1;
		userrole.setId(id1);
	//	userDao.delete(userrole,userdetail);
		
		userDao.delete(userdetail,userrole);
	}
	

}
