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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LandDetailsTable")
public class LandDetails implements Serializable {
	private static final long serialVersionUID = 452124L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="land_id")
	private int id;
	
	@Column(name="ownerFirstName")
	private String ownerFirstName;
	
	@Column(name="ownerLastName")
	private String ownerLastName;
	
	
	
	@Column(name="ownerContact")
	private String ownerContact;
	
	@Column(name="propertyPrice")
	private double propertyPrice;
	
	@Column(name="propertyLocation")
	private String propertyLocation;
	
	@Column(name="propertyState")
	private String propertyState;
	
	@Column(name="propertyCity")
	private String propertyCity;
	
   
	
	

	
	private String landFaced;
	private int landRoad;
	
	
	private double ropaniSize;
	private double aanaSize;
	private double paisaSize;
	private double damSize;
	
	private String[] landImage;
	private String[] lalpurjaImage;
	private String[] citizenshipImage;
	
	private boolean validatedata;
	

	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ud_id",nullable=false)
	private UserDetail userDetails;   // who adds the property
	
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="agent_id")
	private UserDetail agentDetails;
	
	
	public LandDetails() {
		super();
		// TODO Auto-generated constructor stub


	}








	public LandDetails(int id, String ownerFirstName, String ownerLastName, String ownerContact, double propertyPrice,
			String propertyLocation, String propertyState, String propertyCity, String landFaced, int landRoad,
			double ropaniSize, double aanaSize, double paisaSize, double damSize, String[] landImage,
			String[] lalpurjaImage, String[] citizenshipImage, boolean validatedata, 
			UserDetail userDetails, UserDetail agentDetails) {
		super();
		this.id = id;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerContact = ownerContact;
		this.propertyPrice = propertyPrice;
		this.propertyLocation = propertyLocation;
		this.propertyState = propertyState;
		this.propertyCity = propertyCity;
		this.landFaced = landFaced;
		this.landRoad = landRoad;
		this.ropaniSize = ropaniSize;
		this.aanaSize = aanaSize;
		this.paisaSize = paisaSize;
		this.damSize = damSize;
		this.landImage = landImage;
		this.lalpurjaImage = lalpurjaImage;
		this.citizenshipImage = citizenshipImage;
		this.validatedata = validatedata;
		
		this.userDetails = userDetails;
		this.agentDetails = agentDetails;
	}








	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOwnerFirstName() {
		return ownerFirstName;
	}


	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}


	public String getOwnerLastName() {
		return ownerLastName;
	}


	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}


	public String getOwnerContact() {
		return ownerContact;
	}


	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}


	public double getPropertyPrice() {
		return propertyPrice;
	}


	public void setPropertyPrice(double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}


	public String getPropertyLocation() {
		return propertyLocation;
	}


	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}


	public String getPropertyState() {
		return propertyState;
	}


	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}


	public String getPropertyCity() {
		return propertyCity;
	}


	public void setPropertyCity(String propertyCity) {
		this.propertyCity = propertyCity;
	}


	


	public String getLandFaced() {
		return landFaced;
	}


	public void setLandFaced(String landFaced) {
		this.landFaced = landFaced;
	}


	public int getLandRoad() {
		return landRoad;
	}


	public void setLandRoad(int landRoad) {
		this.landRoad = landRoad;
	}




	public double getRopaniSize() {
		return ropaniSize;
	}


	public void setRopaniSize(double ropaniSize) {
		this.ropaniSize = ropaniSize;
	}


	public double getAanaSize() {
		return aanaSize;
	}


	public void setAanaSize(double aanaSize) {
		this.aanaSize = aanaSize;
	}


	public double getPaisaSize() {
		return paisaSize;
	}


	public void setPaisaSize(double paisaSize) {
		this.paisaSize = paisaSize;
	}


	public double getDamSize() {
		return damSize;
	}


	public void setDamSize(double damSize) {
		this.damSize = damSize;
	}


	public String[] getLandImage() {
		return landImage;
	}


	public void setLandImage(String[] landImage) {
		this.landImage = landImage;
	}


	public String[] getLalpurjaImage() {
		return lalpurjaImage;
	}


	public void setLalpurjaImage(String[] lalpurjaImage) {
		this.lalpurjaImage = lalpurjaImage;
	}


	public String[] getCitizenshipImage() {
		return citizenshipImage;
	}


	public void setCitizenshipImage(String[] citizenshipImage) {
		this.citizenshipImage = citizenshipImage;
	}





	public UserDetail getUserDetails() {
		return userDetails;
	}





	public UserDetail getAgentDetails() {
		return agentDetails;
	}





	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}





	public void setAgentDetails(UserDetail agentDetails) {
		this.agentDetails = agentDetails;
	}











	public boolean isValidatedata() {
		return validatedata;
	}











	public void setValidatedata(boolean validatedata) {
		this.validatedata = validatedata;
	}








	
	
	
	
}
