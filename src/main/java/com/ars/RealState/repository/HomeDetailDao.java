package com.ars.RealState.repository;

import java.util.List;

import org.springframework.ui.Model;

import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.UserDetail;



public interface HomeDetailDao {
	public void insert(HomeDetails hd);
	public List<HomeDetails> selectAll();
	public HomeDetails selectById(int id);
	
	public List<HomeDetails> selectByName(String name);
	
	public void update(HomeDetails menu);
	
	public void delete(int id);

	public List<HomeDetails> selectSortedMenu();
	public List<HomeDetails> selectByAgent(UserDetail agentdetail);
	public List<HomeDetails> selectSortedDataByPrice();
	public int updateHomeById(int id);
	public int deleteHomeById(int id);
	public List<HomeDetails> selectByPriced();
	public List<HomeDetails> searchData(String word);
}
