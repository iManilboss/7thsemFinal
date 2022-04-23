package com.ars.RealState.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="user_detail")
public class UserDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 12222254L;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ud_id")
	private int id;
	
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String phone;
	private LocalDate dob;
	
	private String active;
	@Transient
	private String authority;
	@Column(unique=true)
	private String username;
	private String password;
	private String photo;
	
	@OneToOne(fetch=FetchType.LAZY,cascade =CascadeType.ALL,mappedBy="useerdetail")
	private UserRole userrole;
	
	@OneToMany(fetch=FetchType.LAZY,cascade =CascadeType.ALL,mappedBy="userdetail")
	private List<BuyRequest> buyrequest;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userDetails")
	private List< HomeDetails> homeDetails;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userDetails")
	private List<LandDetails> landDetails;
	
	

	
	public UserDetail() {
		super();
	}

	

	


	public UserDetail(int id, String firstName, String lastName, String email, String phone, LocalDate dob,
			String active, String authority, String username, String password, String photo, UserRole userrole,
			List<BuyRequest> buyrequest, List<HomeDetails> homeDetails, List<LandDetails> landDetails) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.active = active;
		this.authority = authority;
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.userrole = userrole;
		this.buyrequest = buyrequest;
		this.homeDetails = homeDetails;
		this.landDetails = landDetails;
	}


























	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	        
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	



	public List<HomeDetails> getHomeDetails() {
		return homeDetails;
	}



	public void setHomeDetails(List<HomeDetails> homeDetails) {
		this.homeDetails = homeDetails;
	}






	public List<LandDetails> getLandDetails() {
		return landDetails;
	}






	public void setLandDetails(List<LandDetails> landDetails) {
		this.landDetails = landDetails;
	}






	public String getPhoto() {
		return photo;
	}






	public void setPhoto(String photo) {
		this.photo = photo;
	}






	public List<BuyRequest> getBuyrequest() {
		return buyrequest;
	}






	public void setBuyrequest(List<BuyRequest> buyrequest) {
		this.buyrequest = buyrequest;
	}







	





	
	
	

}
