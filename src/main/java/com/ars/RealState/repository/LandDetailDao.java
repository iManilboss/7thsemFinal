package com.ars.RealState.repository;

import java.util.List;

import com.ars.RealState.model.LandDetails;
import com.ars.RealState.model.UserDetail;



public interface LandDetailDao    {
	public void insert(LandDetails ld);
	public List<LandDetails> selectAll();
	public LandDetails selectById(int id);
	
	public List<LandDetails> selectByName(String name);
	
	public void update(LandDetails menu);
	
	public void delete(int id);

	public List<LandDetails> selectSortedData();
	public List<LandDetails> selectSortedDataByPrice();
	public List<LandDetails> selectByAgent(UserDetail agent);
	public int updateLandById(int id);
	public int deleteLandById(int id);
	public List<LandDetails> selectByPriced();
	public List<LandDetails> searchData(String word);
}
