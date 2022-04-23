package com.ars.RealState.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageUploadServiceImpl implements ImageUploadService {
public static final String UPLOAD_DIR = "C://Users//imani//Desktop/image";
	
	public boolean uploadImage(ArrayList<MultipartFile> files) {
		boolean status = false;
		String uploadFolder = UPLOAD_DIR + File.separator + "property_image";
		
		File uploadDir = new File(uploadFolder);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();  // creates image upload dir if not exists
		}
		
		for(MultipartFile file : files) {
			if(file!=null) {
		// creates a uploadfile with filename from a uploaded file
		String uploadFile = uploadFolder + File.separator + file.getOriginalFilename();

		
		
		//creates an empty file to be uploaded into a server, 
		// this only create a logical file inside our app
		
		File uploadImage = new File(uploadFile);
		
		// and data from the upload is transfered into that file
		// thus creating a physical file into our file system
		try {
				file.transferTo(uploadImage);
				status = true;
				// upload success
			} catch (IOException e) {
				System.out.println("image cannot be uploaded.");
				break;
			}
		}
		}
		return status;
	}

	public String[] imageArrayToNameString(MultipartFile[] images) {
		String[] names = new String[images.length];
		for(int i=0; i<images.length; i++) {
			names[i] = images[i].getOriginalFilename();
		}
		return names;
	}

}
