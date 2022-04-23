package com.ars.RealState.repository;

import java.util.List;

import com.ars.RealState.model.BuyRequest;

import com.ars.RealState.model.UserDetail;


public interface homeContactDao {
	public void insert(BuyRequest hd);
	public BuyRequest selectById(int id);
	public List<BuyRequest> selectByAgent(int agentdetail);
	public int updateHomeById(int id);
	public int deleteHomeById(int id);
}
