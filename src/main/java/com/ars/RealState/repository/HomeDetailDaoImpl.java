package com.ars.RealState.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ars.RealState.model.HomeDetails;

import com.ars.RealState.model.UserDetail;
import org.springframework.data.jpa.repository.Modifying;


@Repository
@Transactional

public class HomeDetailDaoImpl implements HomeDetailDao{
	@Autowired
	SessionFactory sessionfactory;

	public void insert(HomeDetails hd) {
		Session session =sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(hd);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<HomeDetails> query = session.createQuery("from HomeDetails hd");
		List<HomeDetails> homedetails = query.getResultList();
		tx.commit();
		session.close();
		return homedetails;
	}

	@SuppressWarnings("unchecked")
	public HomeDetails selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<HomeDetails> query = 
				session.createQuery("from HomeDetails m where id=:mid");
		query.setParameter("mid", id);
		HomeDetails homedetails = query.uniqueResult();
		tx.commit();
		session.close();
		return homedetails;
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> selectByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<HomeDetails> query = 
				session.createQuery("from HomeDetails m where name=:mname");
		query.setParameter("mname", name);
		List<HomeDetails> homedetails = query.getResultList();
		tx.commit();
		session.close();
		return homedetails;
	}

	public void update(HomeDetails menu) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> selectSortedMenu() {
		// TODO Auto-generated method stub
		List<HomeDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query<HomeDetails> query = session.createQuery("from HomeDetails m ORDERBY m.name ASC");
		sortedData = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return sortedData;
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> selectByAgent(UserDetail agentdetail) {
		
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<HomeDetails> query = 
				session.createQuery("from HomeDetails m where agentDetails=:agent");
		query.setParameter("agent", agentdetail);
		List<HomeDetails> homedetails = query.getResultList();
		tx.commit();
		session.close();
		return homedetails;
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> selectSortedDataByPrice() {
		// TODO Auto-generated method stub
		List<HomeDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
	Query<HomeDetails> query = session.createQuery("from HomeDetails m ORDER BY m.propertyPrice ASC");
		sortedData = query.getResultList();
		session.getTransaction().commit();
	session.close();
	return sortedData;
	}

	@SuppressWarnings("unchecked")
	@Modifying
	public int updateHomeById(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		String q = "UPDATE HomeDetails set validatedata=:validatedata"
				+ " where id=:mid";
		Query<HomeDetails> query = 
				session.createQuery(q);
		query.setParameter("mid", id);
		query.setParameter("validatedata", true);
		
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Modifying
	public int deleteHomeById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		String q = "DELETE FROM HomeDetails "
				+ " where id=:mid";
		Query<HomeDetails> query = 
				session.createQuery(q);
		query.setParameter("mid", id);
		
		
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> selectByPriced() {
		// TODO Auto-generated method stub
		List<HomeDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
	Query<HomeDetails> query = session.createQuery("from HomeDetails m ORDER BY m.propertyPrice desc");
		sortedData = query.getResultList();
		session.getTransaction().commit();
	session.close();
	return sortedData;
	}

	@SuppressWarnings("unchecked")
	public List<HomeDetails> searchData(String word) {
		// TODO Auto-generated method stub
		List<HomeDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
	Query<HomeDetails> query = session.createQuery("from HomeDetails m  WHERE m.propertyState=: mid OR  m.houseFaced=:mid OR m.houseType=:mid ");
	query.setParameter("mid", word);		
	sortedData = query.getResultList();
	session.getTransaction().commit();
	session.close();
	return sortedData;
	}

}
