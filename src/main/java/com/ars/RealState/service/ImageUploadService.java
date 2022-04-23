package com.ars.RealState.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
	public boolean uploadImage(ArrayList<MultipartFile> files);
	
	public String[] imageArrayToNameString(MultipartFile[] images);
}
