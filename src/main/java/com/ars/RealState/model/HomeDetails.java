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
@Table(name="HomeDetailsTable")
public class HomeDetails implements Serializable{
	private static final long serialVersionUID = 452124L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Property_id")
	private int id;
	
	@Column(name="ownerFirstName")
	private String ownerFirstName;
	
	@Column(name="ownerLastName")
	private String ownerLastName;
	
	
	
	@Column(name="ownerContact")
	private String ownerContact;
	
	@Column(name="propertyPrice")
	private Long propertyPrice;
	
	@Column(name="propertyLocation")
	private String propertyLocation;
	
	@Column(name="propertyState")
	private String propertyState;
	
	@Column(name="propertyCity")
	private String propertyCity;
	
	@Column(name="propertyType")
	private String propertyType;
	
	@Column(name="propertySize")
	private int propertySize;
	
	
	private int bedroom;
	private int bathroom;
	private int kitchen;
	private int livingRoom;
	private int floor;
	
	private String houseFaced;
	private String houseType;
	private int houseRoad;
	private String [] facilities;
	
	private double ropaniSize;
	private double aanaSize;
	private double paisaSize;
	private double damSize;
	
	private String[] houseImage;
	private String[] lalpurjaImage;
	private String[] citizenshipImage;
	
	private boolean validatedata;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ud_id",nullable=false)
	private UserDetail userDetails;   // who adds the property
	
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="agent_id")
	private UserDetail agentDetails;  // user who is assigned as an Agent
	
	
	public HomeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public HomeDetails(int id, String ownerFirstName, String ownerLastName, String ownerContact, Long propertyPrice,
			String propertyLocation, String propertyState, String propertyCity, String propertyType, int propertySize,
			int bedroom, int bathroom, int kitchen, int livingRoom, int floor, String houseFaced, String houseType,
			int houseRoad, String[] facilities, double ropaniSize, double aanaSize, double paisaSize, double damSize,
			String[] houseImage, String[] lalpurjaImage, String[] citizenshipImage, boolean validatedata,
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
		this.propertyType = propertyType;
		this.propertySize = propertySize;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.kitchen = kitchen;
		this.livingRoom = livingRoom;
		this.floor = floor;
		this.houseFaced = houseFaced;
		this.houseType = houseType;
		this.houseRoad = houseRoad;
		this.facilities = facilities;
		this.ropaniSize = ropaniSize;
		this.aanaSize = aanaSize;
		this.paisaSize = paisaSize;
		this.damSize = damSize;
		this.houseImage = houseImage;
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


	public void setPropertyPrice(Long propertyPrice) {
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


	public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	public int getPropertySize() {
		return propertySize;
	}


	public void setPropertySize(int propertySize) {
		this.propertySize = propertySize;
	}


	public int getBedroom() {
		return bedroom;
	}


	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}


	public int getBathroom() {
		return bathroom;
	}


	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}


	public int getKitchen() {
		return kitchen;
	}


	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}


	public int getLivingRoom() {
		return livingRoom;
	}


	public void setLivingRoom(int livingRoom) {
		this.livingRoom = livingRoom;
	}


	public int getFloor() {
		return floor;
	}


	public void setFloor(int floor) {
		this.floor = floor;
	}


	public String getHouseFaced() {
		return houseFaced;
	}


	public void setHouseFaced(String houseFaced) {
		this.houseFaced = houseFaced;
	}


	public String getHouseType() {
		return houseType;
	}


	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}


	public int getHouseRoad() {
		return houseRoad;
	}


	public void setHouseRoad(int houseRoad) {
		this.houseRoad = houseRoad;
	}


	public String[] getFacilities() {
		return facilities;
	}


	public void setFacilities(String[] facilities) {
		this.facilities = facilities;
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


	public String[] getHouseImage() {
		return houseImage;
	}


	public void setHouseImage(String[] houseImage) {
		this.houseImage = houseImage;
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




	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}




	public UserDetail getAgentDetails() {
		return agentDetails;
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




	





	
