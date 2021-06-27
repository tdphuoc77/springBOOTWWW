package com.onthi.bai17client.config;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {

	public void uploadFile(MultipartFile multipartFile,HttpSession session) {
		
		ServletContext context= session.getServletContext();
		String filePath=
				context.getRealPath("/images")+File.separator +multipartFile.getOriginalFilename();
		System.out.println(filePath);
		
		try {
			byte[] bytes= multipartFile.getBytes();
			BufferedOutputStream stream;
			stream= new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(bytes);
			stream.flush();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
