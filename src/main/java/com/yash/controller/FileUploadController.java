package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yash.support.FileUploadSupport;

@RestController
public class FileUploadController 
{

	@Autowired
	private FileUploadSupport fileUploadSupport;
	
	
	@PostMapping("/fileupload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
		try
		{
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upload the file properly");
		}
		/*
		 * if(!file.getContentType().equals("Image/png")) { return
		 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
		 * body("Only allow png file"); }
		 */
		boolean f=fileUploadSupport.Uploadfile(file);
		if(f)
		{
		 return ResponseEntity.ok("File upload successfully");	
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something sent wrong");
		
		
	}
}
