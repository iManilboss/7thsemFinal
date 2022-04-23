package com.ars.RealState.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.RealState.model.LandDetails;
import com.ars.RealState.model.UserDetail;
import com.ars.RealState.repository.LandDetailDao;

@Service
public  class LandDetailServiceImpl implements LandDetailService {
	
	@Autowired
	LandDetailDao landdetaildao;
	public void saveLandDetails(LandDetails ld) {
		// TODO Auto-generated method stub
		landdetaildao.insert(ld);
	}

	public List<LandDetails> getAllLandDetails() {
		// TODO Auto-generated method stub
		return landdetaildao.selectAll();
	}

	public LandDetails getHomeById(int id) {
		// TODO Auto-generated method stub
		return landdetaildao.selectById(id);
	}

	public List<LandDetails> getDataByName(String name) {
		// TODO Auto-generated method stub
		return landdetaildao.selectByName(name);
	}

	public void updateData(LandDetails hd) {
		// TODO Auto-generated method stub
		
	}

	public List<LandDetails> getSortedData() {
		// TODO Auto-generated method stub
		return landdetaildao.selectSortedData();
	}

	public List<LandDetails> getSortedDataByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public LandDetails getLandById(int id) {
		// TODO Auto-generated method stub
		return landdetaildao.selectById(id);
	}
	
	public List<LandDetails> getSortedDataByPrice() {
//		LandDetails [] unsortedLandDetails = (LandDetails[]) landdetaildao.selectAll().toArray();
//		
//		LandDetails []sortedLandDetail = new LandDetails[unsortedLandDetails.length];
	return landdetaildao.selectSortedDataByPrice();	
		

		
	}

	public List<LandDetails> getHomeDetailByAgent(UserDetail userdetails) {
		// TODO Auto-generated method stub
		return landdetaildao.selectByAgent(userdetails);
	}

	public int updateLandById(int id) {
		// TODO Auto-generated method stub
		return landdetaildao.updateLandById(id);
	}
	
	public int deleteLandById(int id) {
		return landdetaildao.deleteLandById(id);
		
	}

	public void deleteData(int id) {
		// TODO Auto-generated method stub
		
	}

	public Object getSortedDataByPriced() {
		// TODO Auto-generated method stub
		return landdetaildao.selectByPriced();
	}

	public List<LandDetails> searchData(String word) {
		// TODO Auto-generated method stub
		return landdetaildao.searchData(word);
	}
	

}
