package com.ars.RealState.service;

import java.io.File;
import java.io.IOException;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class MenuUploadServiceImpl implements MenuUploadService{
	public static final String UPLOAD_DIR="C://Users//imani//Desktop/image";


	
	
	public boolean uploadMenuImage(MultipartFile file) {
		boolean status= false;
		String uploadFolder =UPLOAD_DIR +File.separator + "agent_images";
		File uploadDir= new File(uploadFolder);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs(); //creates image upload dir if not exists
		}
		//creates  a upload file with filename from a uploaded file
		String uploadFile = uploadFolder +File.separator + file.getOriginalFilename();
		
		//creates an empty file to be uploaded into server
		//this only create a logical file inside our app
		
		File uploadImage = new File(uploadFile);
		//and data from the upload is transferred into that file 
		//thus creating a physical file into our file system
		try {
			file.transferTo(uploadImage);
			status= true;
			//upload sucess
		}
	catch(IOException e) {
			Logger.getMessageLogger(MenuUploadService.class, "Image upload failed");

		}
	
	return status;
}
}
