package com.web.eran.web.controller;
/**
* @author Promise
* @createTime 2018年12月5日 下午9:37:35
* @description 
*/

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.web.eran.shiro.KaptchaErrorException;

@Controller
public class LoginController {

	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private DefaultKaptcha kaptchaConfig;
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,Map<String, Object> map) {
		log.info("get in loinCOntroller!");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        log.info("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                log.info("账号不存在!");
                msg = "用户名密码错误!";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                log.info("密码错误!");
                msg = "用户名密码错误!";
            } else if (KaptchaErrorException.class.getName().equals(exception)) {
                log.info("验证码错误");
                msg = "验证码错误!";
            } else {
                msg = "else >> "+exception;
                log.info("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
	}
	
	@RequestMapping("/kaptcha")
	public void makeKaptcha(HttpServletRequest request,HttpServletResponse response) throws IOException {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {  
	         //生产验证码字符串并保存到session中
	         String createText = kaptchaConfig.createText();
	         request.getSession().setAttribute("vercode", createText);
	         //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = kaptchaConfig.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
	         } catch (IllegalArgumentException e) {  
	             response.sendError(HttpServletResponse.SC_NOT_FOUND);  
	             return;  
	         } 
	   
	         //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
	         captchaChallengeAsJpeg = jpegOutputStream.toByteArray();  
	         response.setHeader("Cache-Control", "no-store");  
	         response.setHeader("Pragma", "no-cache");  
	         response.setDateHeader("Expires", 0);  
	         response.setContentType("image/jpeg");  
	         ServletOutputStream responseOutputStream =  
	        		 response.getOutputStream();  
	         responseOutputStream.write(captchaChallengeAsJpeg);  
	         responseOutputStream.flush();  
	         responseOutputStream.close(); 
		
	}
	
	@RequestMapping("/403")
    public String unauthorizedRole(){
        log.info("------没有权限-------");
        return "common/403";
    }
}
