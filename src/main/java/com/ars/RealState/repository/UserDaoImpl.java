package com.ars.RealState.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.RealState.model.UserDetail;
import com.ars.RealState.model.UserRole;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {
@Autowired
 SessionFactory sessionfactory;
	public void insert(UserDetail ud) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRole ur = new UserRole();
		if(ud.getAuthority().equals("ADMIN")) {
			ur.setRole("ROLE_ADMIN");
		}else if(ud.getAuthority().equals("USER")) {
			ur.setRole("ROLE_USER");
		}
		else if(ud.getAuthority().equals("AGENT")) {
			ur.setRole("ROLE_AGENT");
		}else {
			ur.setRole("ANYNOMOUS");
		}
		
		//creates a bi-directioonal relationship between entity
		ur.setUseerdetail(ud);
		ud.setUserrole(ur);
		
		//we need to save only UserDetail object
		session.save(ud);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public UserDetail selectByUsername(String name) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query<UserDetail> query= session.createQuery("from UserDetail ud where username=:uname");
		query.setParameter("uname", name);
		UserDetail ud= query.uniqueResult();

	session.getTransaction().commit();
	session.close();
	return ud;
}
	@SuppressWarnings("unchecked")
	public List<UserDetail> selectByUserRole(String role) {
		System.out.println("Rading users from database");
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query<UserDetail> query= session.createQuery("from UserDetail as ud where "
				+ "ud.userrole.role=:urole");
		query.setParameter("urole", role);
		List<UserDetail> uds= query.list();
			
	session.getTransaction().commit();
	session.close();
		return uds;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public UserDetail selectById(int aid) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query<UserDetail> query= session.createQuery("from UserDetail ud where ud_id=:uid");
		query.setParameter("uid",aid);
		UserDetail ud= query.uniqueResult();

	session.getTransaction().commit();
	session.close();
	return ud;
	}
	
	public List<UserDetail> selectByrole(String role) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query<UserDetail> q = session.createQuery("from UserDetail as ud where "
				+ "ud.userrole.role=:urole");
		q.setParameter("urole", role);
		List<UserDetail> a_detail = q.list();
		session.getTransaction().commit();
		session.close();
		return a_detail;
	}

	public void update(UserDetail userdetail) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UserDetail userdetail,UserRole userrole) {
//		Session session = sessionfactory.openSession();
//		session.beginTransaction();
//		String hql = "DELETE FROM UserRole WHERE id = :ur_id";
//	Query query = session.createQuery(hql);
//	query.setParameter("ur_id", 10);
//	int result = query.executeUpdate();
//	
////		session.delete(userrole);
////		session.getTransaction().commit();
////		session.close();
////		
////		Session Session = sessionfactory.openSession();
////		Session.beginTransaction();
//		String hql1 = "DELETE FROM UserDetail WHERE id = :ud_id";
//		Query query1 = session.createQuery(hql1);
//		query.setParameter("ud_id", 10);
//		int result1 = query.executeUpdate();
//		session.getTransaction().commit();
//		session.close();		
////	System.out.println("Rows affected: " + result);
		
	}
}