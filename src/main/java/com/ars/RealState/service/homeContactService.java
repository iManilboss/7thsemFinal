package com.ars.RealState.service;

import java.util.List;

import com.ars.RealState.model.BuyRequest;
import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.UserDetail;

public interface homeContactService {
	public void savecontactDetails(BuyRequest br);
	public BuyRequest getHomeById(int id);
	public List<BuyRequest> getbuyDetailByAgent(int userdetails);
	
	public int deletebuyhomeById(int id);
}
