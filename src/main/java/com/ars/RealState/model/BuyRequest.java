package com.ars.RealState.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="BuyRequest")
public class BuyRequest implements Serializable {
	private static final long serialVersionUID = 452124L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="buy_id")
	private int id;
	
	private String message;
	private int land;
	private int home;
	private int agent;
	private int user;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserDetail userdetail;

	public BuyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	


	public BuyRequest(int id, String message, int land, int home, int agent, int user, UserDetail userdetail) {
		super();
		this.id = id;
		this.message = message;
		this.land = land;
		this.home = home;
		this.agent = agent;
		this.user = user;
		this.userdetail = userdetail;
	}






	public int getAgent() {
		return agent;
	}

	public int getUser() {
		return user;
	}

	public void setAgent(int agent) {
		this.agent = agent;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	



	public void setId(int id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public int getLand() {
		return land;
	}



	public int getHome() {
		return home;
	}



	



	public void setLand(int land) {
		this.land = land;
	}



	public void setHome(int home) {
		this.home = home;
	}






	public UserDetail getUserdetail() {
		return userdetail;
	}






	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}



	




	

	
	
	
	
}
