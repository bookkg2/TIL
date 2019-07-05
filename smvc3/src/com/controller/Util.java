package com.controller;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void savrFile(MultipartFile mf) {
		String dir = "C:\\spring\\smvc3\\web\\img\\";//디렉토리 위치
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = new FileOutputStream(dir+imgname);//어떤 이름으로 넣을건지
			fo.write(data);//이미지가 들어감
			fo.close();
		}catch(Exception e) {
			
		}
		
	}
}
