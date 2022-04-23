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


import com.ars.RealState.model.LandDetails;
import com.ars.RealState.model.UserDetail;

@Repository
@Transactional
public class LandDetailDaoImpl implements LandDetailDao {
	@Autowired
	SessionFactory sessionfactory;

	public void insert(LandDetails ld) {
		// TODO Auto-generated method stub
		Session session =sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ld);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<LandDetails> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<LandDetails> query = session.createQuery("from LandDetails hd");
		List<LandDetails> landdetails = query.getResultList();
		tx.commit();
		session.close();
		return landdetails;
	}

	@SuppressWarnings("unchecked")
	public LandDetails selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<LandDetails> query = 
				session.createQuery("from LandDetails m where id=:mid");
		query.setParameter("mid", id);
		LandDetails landdetails = query.uniqueResult();
		tx.commit();
		session.close();
		return landdetails;
	}

	@SuppressWarnings("unchecked")
	public List<LandDetails> selectByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query<LandDetails> query = 
				session.createQuery("from LandDetails m where name=:mname");
		query.setParameter("mname", name);
		List<LandDetails> landdetails = query.getResultList();
		tx.commit();
		session.close();
		return landdetails;
	}

	public void update(LandDetails menu) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<LandDetails> selectSortedData() {
		// TODO Auto-generated method stub
		List<LandDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query<LandDetails> query = session.createQuery("from LandDetails m ORDERBY m.name ASC");
		sortedData = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return sortedData;
	}
	
	@SuppressWarnings("unchecked")
	public List<LandDetails> selectSortedDataByPrice() {
		// TODO Auto-generated method stub
	List<LandDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
	Query<LandDetails> query = session.createQuery("from LandDetails m ORDER BY m.propertyPrice ASC");
		sortedData = query.getResultList();
		session.getTransaction().commit();
	session.close();
		return sortedData;
	}

	public List<LandDetails> selectByAgent(UserDetail agent) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<LandDetails> query = 
				session.createQuery("from LandDetails m where agentDetails=:agent");
		query.setParameter("agent", agent);
		List<LandDetails> landdetails = query.getResultList();
		tx.commit();
		session.close();
		return landdetails;
	}
	
    @SuppressWarnings("unchecked")
	@Modifying
	public int updateLandById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		String q = "UPDATE LandDetails set validatedata=:validatedata"
				+ " where id=:mid";
		Query<LandDetails> query = 
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
	public int deleteLandById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		String q = "DELETE FROM LandDetails "
				+ " where id=:mid";
		Query<LandDetails> query = 
				session.createQuery(q);
		query.setParameter("mid", id);
		
		
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<LandDetails> selectByPriced() {
		// TODO Auto-generated method stub
		List<LandDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
	Query<LandDetails> query = session.createQuery("from LandDetails m ORDER BY m.propertyPrice desc");
		sortedData = query.getResultList();
		session.getTransaction().commit();
	session.close();
		return sortedData;
	}

	@SuppressWarnings("unchecked")
	public List<LandDetails> searchData(String word) {
		// TODO Auto-generated method stub
		List<LandDetails> sortedData = null;
		Session session = sessionfactory.openSession();
		session.beginTransaction();
	Query<LandDetails> query = session.createQuery("from LandDetails m  WHERE m.propertyState=: mid OR  m.landFaced=:mid ");
	query.setParameter("mid", word);	
	sortedData = query.getResultList();
		
		session.getTransaction().commit();
	session.close();
	return sortedData;
	}

}
