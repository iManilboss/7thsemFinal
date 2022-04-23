package com.ars.RealState.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.UserDetail;
import com.ars.RealState.repository.HomeDetailDao;

@Service
public class HomeDetailServiceImpl implements HomeDetailService{
@Autowired
HomeDetailDao homedetaildao;
	public void saveHomeDetails(HomeDetails hd) {
		homedetaildao.insert(hd);
		
	}
	public List<HomeDetails> getAllHomeDetails() {
		// TODO Auto-generated method stub
		return homedetaildao.selectAll();
	}
	public HomeDetails getHomeById(int id) {
		// TODO Auto-generated method stub
		return homedetaildao.selectById(id);
	}
	public List<HomeDetails> getDataByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateData(HomeDetails hd) {
		// TODO Auto-generated method stub
		
	}
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		
	}
	public List<HomeDetails> getSortedData() {
		// TODO Auto-generated method stub
		return homedetaildao.selectSortedMenu();
	}
	public List<HomeDetails> getSortedDataByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<HomeDetails> getHomeDetailByAgent(UserDetail userdetails) {
		// TODO Auto-generated method stub
		return homedetaildao.selectByAgent(userdetails );
	}
	public Object getSortedDataByPrice() {
		// TODO Auto-generated method stub
		return homedetaildao.selectSortedDataByPrice();
	}
	public int updateHomeById(int id) {
		// TODO Auto-generated method stub
		return homedetaildao.updateHomeById(id);
	}
	public int deleteHomeById(int id) {
		// TODO Auto-generated method stub
		return homedetaildao.deleteHomeById(id);
	}
	public Object getSortedDataByPriced() {
		// TODO Auto-generated method stub
		return homedetaildao.selectByPriced();
	}
	public List<HomeDetails> searchData(String word) {
		// TODO Auto-generated method stub
		return homedetaildao.searchData( word);
	}

}
