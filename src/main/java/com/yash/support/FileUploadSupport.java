package com.yash.support;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadSupport {
	
	public final String UPLOAD_DIR=
			"C:\\Users\\shubham.tembhare\\Documents\\projects\\07-FileUploading_SpringBoot\\src\\main\\resources\\static\\Image\\";

	public boolean Uploadfile(MultipartFile multipartFile)
	{
		boolean f=false;
		
		try {
			
			
//			InputStream is=multipartFile.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			
//			//write
//			FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fos.flush();
//			fos.close();
			//or below  code
			
	Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);		
			f=true;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return f;
	}
}
