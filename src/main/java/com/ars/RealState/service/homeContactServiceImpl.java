package com.ars.RealState.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.RealState.model.BuyRequest;
import com.ars.RealState.model.UserDetail;
import com.ars.RealState.repository.homeContactDao;

@Service
public class homeContactServiceImpl implements homeContactService {
	
@Autowired 
homeContactDao homecontactdao;
	public void savecontactDetails(BuyRequest br) {
		// TODO Auto-generated method stub
		homecontactdao.insert(br);
	}

	public List<BuyRequest> getbuyDetailByAgent(int userdetails) {
		// TODO Auto-generated method stub
		return homecontactdao.selectByAgent(userdetails);
	}

	public int updatebuyhomeById(int id) {
		// TODO Auto-generated method stub
		return homecontactdao.updateHomeById(id);
	}

	public int deletebuyhomeById(int id) {
		// TODO Auto-generated method stub
		return homecontactdao.deleteHomeById(id);
	}

	public BuyRequest getHomeById(int id) {
		// TODO Auto-generated method stub
		return homecontactdao.selectById(id);
	}

}
