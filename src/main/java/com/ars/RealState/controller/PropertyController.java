package com.ars.RealState.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ars.RealState.model.BuyRequest;
import com.ars.RealState.model.HomeDetails;
import com.ars.RealState.model.LandDetails;
//import com.ars.RealState.model.LandDetails;
import com.ars.RealState.model.UserDetail;
import com.ars.RealState.service.HomeDetailService;
import com.ars.RealState.service.ImageUploadService;
import com.ars.RealState.service.LandDetailService;
import com.ars.RealState.service.MenuUploadService;
import com.ars.RealState.service.UserService;
import com.ars.RealState.service.homeContactService;


@Controller
public class PropertyController {
	
	@Autowired
	ImageUploadService imageuploadservice;
	
	@Autowired
	HomeDetailService homedetailservice;
	
	@Autowired
	LandDetailService landdetailservice;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuUploadService menuuploadservice;
	
	@Autowired
	homeContactService homecontactservice;
	
	
	
	@GetMapping("/user/addproperty")
	
	public String addproperty(Model model) {
		
	
		model.addAttribute("agentlist",userService.getUserByRole("ROLE_AGENT")); 
		return "AddProperty";
	}
	

	
	
	@PostMapping("/user/addHome")
	
	public String addHomes(Principal p,
			@RequestParam("ownerFirstName")String ownerFirstName,
			@RequestParam("ownerLastName")String ownerLastName,
			@RequestParam("ownerContact")String ownerContact,
			@RequestParam("propertyPrice")Long propertyPrice,
			@RequestParam("propertyLocation")String propertyLocation,
			@RequestParam("propertyState")String propertyState,
			@RequestParam("propertyCity")String propertyCity,
			@RequestParam("propertyType")String propertyType,
			@RequestParam("propertySize")int propertySize,
			@RequestParam("bedroom")int bedroom,
			@RequestParam("bathroom")int bathroom,
			@RequestParam("kitchen")int kitchen,
			@RequestParam("livingRoom")int livingRoom,
			@RequestParam("floor")int floor,
			@RequestParam("houseFaced")String houseFaced,
			@RequestParam("houseType")String houseType,
			@RequestParam("houseRoad")int houseRoad,
			@RequestParam("facilities")String[] facilities,
			@RequestParam("ropaniSize")double ropaniSize,
			@RequestParam("aanaSize")double aanaSize,
			@RequestParam("paisaSize")double paisaSize,
			@RequestParam("damSize")double damSize,
			@RequestParam("houseImage")MultipartFile houseImage[],
			@RequestParam("lalpurjaImage")MultipartFile lalpurjaImage[],
			@RequestParam("citizenshipImage")MultipartFile citizenshipImage[],
			@RequestParam("agent") int aid,
			@RequestParam("validatedata") boolean validatedata
			) {
	
		ArrayList<MultipartFile> files =  new ArrayList<MultipartFile>();
		for(MultipartFile image: houseImage) {
			files.add(image);	
		}
		for(MultipartFile image: lalpurjaImage) {
			files.add(image);
		}
		for(MultipartFile image: citizenshipImage) {
			files.add(image);
		}
		
		if(imageuploadservice.uploadImage(files)) {
			HomeDetails hd = new HomeDetails();
			hd.setOwnerFirstName(ownerFirstName);
			hd.setOwnerLastName(ownerLastName);
			hd.setOwnerContact(ownerContact);
			hd.setPropertyPrice(propertyPrice);
			hd.setPropertyLocation(propertyLocation);
			hd.setPropertyState(propertyState);
			hd.setPropertyCity(propertyCity);
			hd.setPropertyType(propertyType);
			hd.setPropertySize(propertySize);
			hd.setBedroom(bedroom);
			hd.setBathroom(bathroom);
			hd.setKitchen(kitchen);
			hd.setLivingRoom(livingRoom);
			hd.setHouseFaced(houseFaced);
			hd.setHouseRoad(houseRoad);
			hd.setHouseType(houseType);
			hd.setFloor(floor);
			hd.setFacilities(facilities);
			hd.setRopaniSize(ropaniSize);
			hd.setAanaSize(aanaSize);
			hd.setPaisaSize(paisaSize);
			hd.setDamSize(damSize);
			hd.setValidatedata(validatedata);
			hd.setHouseImage(imageuploadservice.imageArrayToNameString(houseImage));
			hd.setLalpurjaImage(imageuploadservice.imageArrayToNameString(lalpurjaImage));
			hd.setCitizenshipImage(imageuploadservice.imageArrayToNameString(citizenshipImage));
			UserDetail user = userService.getUserDetailByUsername(p.getName());
			System.out.println(p.getName());
			//user.setHomeDetails(hd);
			hd.setUserDetails(user);
			UserDetail agent = userService.getUserDetailById(aid);
			//agent.setHomeDetails(hd);
			hd.setAgentDetails(agent);
			homedetailservice.saveHomeDetails(hd);
		}

		
		return "redirect:/Home";
	
	}
	




	
	@GetMapping("/home")
	public String showHomeDetails(Model model) {
		model.addAttribute("homedetails", homedetailservice.getAllHomeDetails());
		return "propertyDetails";
	}
	
	
	
	
	@GetMapping("/onedetail/{id}")
	public String showDataDetails(@PathVariable("id") int id, Model model) {
		HomeDetails homedetails = homedetailservice.getHomeById(id);
		model.addAttribute("onedetails", homedetails);
		return "morePropertyDetails";
	}
	
	
	
	
	
	
//contact agent for house
	
@GetMapping("/user/contactAgent/{id}")
	
	public String addAgent(@PathVariable("id") int id, Model model,Principal principal ) {
	model.addAttribute("user",principal.getName());
	model.addAttribute("userDetails", userService.getUserDetailByUsername(principal.getName()));
	model.addAttribute("homedetails", homedetailservice.getHomeById(id));
	
	
	return "contactAgent";
	}
	

@PostMapping("/user/contactAgent")

public String submitpropertyTOAgent(@RequestParam("message") String message,
		                            @RequestParam("agent") int agent,
		                            @RequestParam("user") int user,
                                    @RequestParam("house") int house){
	
	BuyRequest br = new BuyRequest();
	br.setMessage(message);
	br.setAgent(agent);
	UserDetail us = userService.getUserDetailById(user);
	br.setUserdetail(us);
	br.setHome(house);
	
	
	homecontactservice.savecontactDetails(br);
	
	return "redirect:/Home";									
	}
	


//contact agent for land

@GetMapping("/user/contactlandAgent/{id}")

public String addlAgent(@PathVariable("id") int id, Model model ) {


model.addAttribute("landdetails",landdetailservice.getLandById(id));

return "contactlAgent";
}

@PostMapping("/user/contactlandAgent")

public String submitlpropertyTOAgent(@RequestParam("message") String message,
	                            @RequestParam("agent") int agent,
	                            @RequestParam("user") int user,
	                           @RequestParam("land") int land)
                             
	                           {
BuyRequest br = new BuyRequest();
br.setMessage(message);
br.setAgent(agent);
UserDetail us = userService.getUserDetailById(user);
br.setUserdetail(us);
br.setLand(land);

homecontactservice.savecontactDetails(br);

//br.setLandDetails(land);
return "redirect:/Home";	


}


//land controller

@GetMapping("/user/addLand")

public String addLand( Model model) {
	model.addAttribute("agentlist",userService.getUserByRole("ROLE_AGENT")); 
	return "AddLand";
}

@PostMapping("user/addLand")
public String addLand(Principal p,
		@RequestParam("ownerFirstName")String ownerFirstName,
		@RequestParam("ownerLastName")String ownerLastName,
		@RequestParam("ownerContact")String ownerContact,
		@RequestParam("propertyPrice")Long propertyPrice,
		@RequestParam("propertyLocation")String propertyLocation,
		@RequestParam("propertyState")String propertyState,
		@RequestParam("propertyCity")String propertyCity,
		
		
		@RequestParam("landFaced")String landFaced,
		
		@RequestParam("landRoad")int landRoad,
		
		@RequestParam("ropaniSize")double ropaniSize,
		@RequestParam("aanaSize")double aanaSize,
		@RequestParam("paisaSize")double paisaSize,
		@RequestParam("damSize")double damSize,
		@RequestParam("landImage")MultipartFile landImage[],
		@RequestParam("lalpurjaImage")MultipartFile lalpurjaImage[],
		@RequestParam("citizenshipImage")MultipartFile citizenshipImage[],
		@RequestParam("agent") int aid,
		@RequestParam("validatedata") boolean validatedata
		) {

	ArrayList<MultipartFile> files =  new ArrayList<MultipartFile>();
	for(MultipartFile image: landImage) {
		files.add(image);	
	}
	for(MultipartFile image: lalpurjaImage) {
		files.add(image);
	}
	for(MultipartFile image: citizenshipImage) {
		files.add(image);
	}
	
	if(imageuploadservice.uploadImage(files)) {
		LandDetails hd = new LandDetails();
		hd.setOwnerFirstName(ownerFirstName);
		hd.setOwnerLastName(ownerLastName);
		hd.setOwnerContact(ownerContact);
		hd.setPropertyPrice(propertyPrice);
		hd.setPropertyLocation(propertyLocation);
		hd.setPropertyState(propertyState);
		hd.setPropertyCity(propertyCity);
		
		
		
		hd.setLandFaced(landFaced);
		hd.setLandRoad(landRoad);
		
	
		hd.setValidatedata(validatedata);
		hd.setRopaniSize(ropaniSize);
		hd.setAanaSize(aanaSize);
		hd.setPaisaSize(paisaSize);
		hd.setDamSize(damSize);
		hd.setLandImage(imageuploadservice.imageArrayToNameString(landImage));
		hd.setLalpurjaImage(imageuploadservice.imageArrayToNameString(lalpurjaImage));
		hd.setCitizenshipImage(imageuploadservice.imageArrayToNameString(citizenshipImage));
		UserDetail user = userService.getUserDetailByUsername(p.getName());
		System.out.println(p.getName());
		//user.setLandDetails(hd);
		hd.setUserDetails(user);
		UserDetail agent = userService.getUserDetailById(aid);
		//agent.setLandDetails(hd);
		hd.setAgentDetails(agent);
		landdetailservice.saveLandDetails(hd);
	}

	
	return "redirect:/Home";

}

@GetMapping("/land")
public String showLandDetails(Model model) {
	model.addAttribute("landdetails", landdetailservice.getAllLandDetails());
	return "landDetails";
}




@GetMapping("/landonedetail/{id}")
public String showLandDataDetails(@PathVariable("id") int id, Model model) {
	LandDetails landdetails = landdetailservice.getLandById(id);
	model.addAttribute("onedetails", landdetails);
	return "moreLandDetails";
}



@GetMapping("/getsortedlandbyprice")
public String getsortedlandbyprice(Model model) {
	
	model.addAttribute("landdetails", landdetailservice.getSortedDataByPrice());
	return "landDetails";
}

@GetMapping("/getsortedhousebyprice")
public String getsortedhousebyprice(Model model) {
	
	model.addAttribute("homedetails", homedetailservice.getSortedDataByPrice());
	return "propertyDetails";
}


//sorting by decreasing
@GetMapping("/getsortedlandbypricedes")
public String getsortedlandbypricee(Model model) {
	
	model.addAttribute("landdetails", landdetailservice.getSortedDataByPriced());
	return "landDetails";
}

@GetMapping("/getsortedhousebypricedes")
public String getsortedhousebypricee(Model model) {
	
	model.addAttribute("homedetails", homedetailservice.getSortedDataByPriced());
	return "propertyDetails";
}



//searching by province,type,faced,

@GetMapping("/search")
public String searchHome(@RequestParam("keyword") String word,Model model) {
	
List<HomeDetails> homedetails = homedetailservice.searchData(word);
model.addAttribute("homedetails",homedetails);
//model.addAttribute("keyword",word);
return "propertyDetails";
	
}

@GetMapping("/searchLand")
public String searchLand(@RequestParam("keyword") String word,Model model) {
	List<LandDetails> landdetails = landdetailservice.searchData(word);
	model.addAttribute("landdetails",landdetails);
	//model.addAttribute("keyword",word);
	return "landDetails";
	
}

//it is used by agent to update and delete details of the sell property(accept,reject)

@GetMapping("/updateHome/{id}")
public String updateHome(@PathVariable("id") int id,Model model) {
	
	int homedetails = homedetailservice.updateHomeById(id);
	model.addAttribute("homedetails",homedetails);
	return "Agent/AgentHome";
}

@GetMapping("/updateLand/{id}")
public String updateLand(@PathVariable("id") int id,Model model) {
	
	int landdetails = landdetailservice.updateLandById(id);
	model.addAttribute("landdetails",landdetails);
	return "Agent/AgentHome";
}

@GetMapping("/deleteHome/{id}")
public String deleteHome(@PathVariable("id") int id,Model model) {
	
	int homedetails = homedetailservice.deleteHomeById(id);
	model.addAttribute("homedetails",homedetails);
	return "Agent/AgentHome";
}


@GetMapping("/deleteLand/{id}")
public String deleteLand(@PathVariable("id") int id,Model model) {
	
	int landdetails = landdetailservice.deleteLandById(id);
	model.addAttribute("landdetails",landdetails);
	return "Agent/AgentHome";
}

//it is used by agent to update and delete details of the buy property(remove,reject)



@GetMapping("/deletebuyHome/{id}")
public String deletebuyHome(@PathVariable("id") int id,Model model) {
	
	int homedetails = homecontactservice.deletebuyhomeById(id);
	model.addAttribute("homedetails",homedetails);
	return "Agent/AgentHome";
}









}

