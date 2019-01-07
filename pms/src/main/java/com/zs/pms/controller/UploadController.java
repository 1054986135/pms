package com.zs.pms.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
@RequestMapping("/commupload.do")
/**
 * ajax返回
 * 如果返回字符串则返回字符串
 * 如果返回对象或对象集合则返回json串
 * 要求导入json包
 */
@ResponseBody
	public String commonUploadFile(MultipartFile file,HttpServletRequest req) {
//	为解决重名问题，利用算法
	/*
	 * uuid生成32位随机码，根据ip、网卡地址、时间等因素生成，保证任何情况下不重复
	 */
//	生成前缀
	String prefix=UUID.randomUUID().toString();
//	生成的目标文件名 前缀+源文件名
	String dfilename=prefix+file.getOriginalFilename();
//	获得服务器的物理路径
	String path=req.getRealPath("/upload");
//	创建目标文件
//	File.separator文件分隔符
	File dFile=new File(path+File.separator+dfilename);
	try {
		file.transferTo(dFile);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	不返回页面，因为是异步的ajax
//	返回目标文件名
	return dfilename;
	}
}
