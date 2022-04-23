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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 12222254L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ur_id")
	private int id;
	private String role;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ud_id", nullable=false)
	private UserDetail useerdetail;
	
	

	public UserRole() {
		super();
	}

	public UserRole(int id, String role, UserDetail useerdetail) {
		super();
		this.id = id;
		this.role = role;
		this.useerdetail = useerdetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDetail getUseerdetail() {
		return useerdetail;
	}

	public void setUseerdetail(UserDetail useerdetail) {
		this.useerdetail = useerdetail;
	}

	
}
