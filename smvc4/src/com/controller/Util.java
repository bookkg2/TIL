package com.controller;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void savrFile(MultipartFile mf) {
		String dir = "C:\\spring\\smvc3\\web\\img\\";//���丮 ��ġ
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = new FileOutputStream(dir+imgname);//� �̸����� ��������
			fo.write(data);//�̹����� ��
			fo.close();
		}catch(Exception e) {
			
		}
		
	}
}
