package com.ars.RealState.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ars.RealState.model.BuyRequest;
import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.UserDetail;


@Repository
@Transactional
public class homeContactDaoImpl implements homeContactDao {
	
	
	@Autowired
	SessionFactory sessionfactory;
	public void insert(BuyRequest hd) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(hd);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public BuyRequest selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<BuyRequest> query = 
				session.createQuery("from BuyRequest m where id=:mid");
		query.setParameter("mid", id);
		BuyRequest buyrequest = query.uniqueResult();
		tx.commit();
		session.close();
		return buyrequest;
	}
	
	@SuppressWarnings("unchecked")
	@Modifying
	public int updateHomeById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		String q = "UPDATE BuyRequeset set validatedata=:validatedata"
				+ " where id=:mid";
		Query<BuyRequest> query = 
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
		String q = "DELETE FROM BuyRequest "
				+ " where id=:mid";
		Query<BuyRequest> query = 
				session.createQuery(q);
		query.setParameter("mid", id);
		
		
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return result;
		}

	@SuppressWarnings("unchecked")
	public List<BuyRequest> selectByAgent(int agentdetail) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<BuyRequest> query = 
				session.createQuery("from BuyRequest m where m.agent=:agent");
		query.setParameter("agent", agentdetail);
		List<BuyRequest> homedetails = query.getResultList();
		tx.commit();
		session.close();
		return homedetails;
	}

	

}
