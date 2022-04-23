package com.ars.RealState.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.UserDetail;



public interface HomeDetailService {
	public void saveHomeDetails(HomeDetails hd);
	public List<HomeDetails> getAllHomeDetails();
    public HomeDetails getHomeById(int id);
	
	public List<HomeDetails> getDataByName(String name);
	
	public void updateData(HomeDetails hd);
	
	public void deleteData(int id);
	
	public List<HomeDetails> getSortedData();
	
	public List<HomeDetails> getSortedDataByType(String type);
	public List<HomeDetails> getHomeDetailByAgent(UserDetail userdetails);
	public Object getSortedDataByPrice();
	public int updateHomeById(int id);
	public int deleteHomeById(int id);
	public Object getSortedDataByPriced();
	public List<HomeDetails> searchData(String word);
}
