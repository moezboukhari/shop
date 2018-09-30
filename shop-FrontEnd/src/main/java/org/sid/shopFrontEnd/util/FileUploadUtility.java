package org.sid.shopFrontEnd.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
private static final String ABSOLUT_PATH ="C:\\Users\\moez\\workspace-sts-3.9.5.RELEASE\\shop\\shop-FrontEnd\\src\\main\\resources\\static\\assets\\images\\";
private static String REAL_PATH="";
private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
//get real path
	REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images");
	
	//pour verifier que le repertoir existe
	if(!new File(ABSOLUT_PATH).exists()) {
		//create directory
		new File(ABSOLUT_PATH).mkdirs();
	}
	if(!new File(REAL_PATH).exists()) {
		//create directory
		new File(REAL_PATH).mkdirs();
	}
	logger.debug("befor transfert");
	//server
	try {
		
		
		file.transferTo(new File(ABSOLUT_PATH + code + ".jpg"));
		
		//file.transferTo(new File(REAL_PATH + code + ".jpg"));
		logger.debug(REAL_PATH + code + ".jpg");
		
		
		
	} catch (IllegalStateException e) {
		logger.debug("1111"+e.toString());
		//
	} catch (IOException e) {
		e.printStackTrace();	}
}
}
