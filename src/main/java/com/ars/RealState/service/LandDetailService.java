package com.ars.RealState.service;

import java.util.List;

import com.ars.RealState.model.LandDetails;
import com.ars.RealState.model.UserDetail;



public interface LandDetailService {
	public void saveLandDetails(LandDetails ld);
	public List<LandDetails> getAllLandDetails();
    public LandDetails getHomeById(int id);
	
	public List<LandDetails> getDataByName(String name);
	
	public void updateData(LandDetails hd);
	
	public void deleteData(int id);
	
	public List<LandDetails> getSortedData();
	
	public List<LandDetails> getSortedDataByType(String type);
	public LandDetails getLandById(int id);
	public List<LandDetails> getSortedDataByPrice();
	public List<LandDetails> getHomeDetailByAgent(UserDetail userdetails);
	public int updateLandById(int id);
	public int deleteLandById(int id);
	public Object getSortedDataByPriced();
	public List<LandDetails> searchData(String word);
}
