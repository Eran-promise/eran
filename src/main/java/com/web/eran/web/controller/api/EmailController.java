package com.web.eran.web.controller.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
* @author Promise
* @createTime 2018年12月19日 下午9:30:38
* @description  邮件发送
*/
@Api(value="邮件发送接口")
@RequestMapping("/api/v1")
@RestController
public class EmailController {
	@Autowired
	private JavaMailSender jms;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Value("${spring.mail.username}")
	private String from;
	
	@ApiOperation(value="简单邮件发送", notes="发送一份简单的邮件")
	@ApiImplicitParams({
		@ApiImplicitParam(name="toUser", value="接收者", required=true, dataType="String")
	})
	@PostMapping("/simpleMail")
	public Map<String, Object> sendSimpleMail(@RequestBody String toUser) {
		Map<String, Object> map =new HashMap<>();
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(from);
			message.setTo(toUser);
			message.setSubject("简单邮件");
			message.setText("简单内容");
			jms.send(message);
			map.put("res", "success");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("res", "error");
		}
		return map;
	}
	
	@ApiOperation(value="html格式邮件发送", notes="发送一份html格式的邮件")
	@ApiImplicitParams({
		@ApiImplicitParam(name="toUser", value="接收者", required=true, dataType="String")
	})
	@PostMapping("/htmlMail")
	public Map<String, Object> htmlMail(@RequestBody String toUser){
		Map<String, Object> map =new HashMap<>();
		MimeMessage  message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(toUser);
			helper.setSubject("html格式邮件");
			String content = "<p style='color:red;'>这是一封html格式的文件</p><h1>这是一封html格式的文件</h1>";
			helper.setText(content, true);
			jms.send(message);
			map.put("res", "success");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("res", "error");
		} catch(MessagingException e) {
			e.printStackTrace();
			map.put("res", "error");
		}
		return map;
	}
	
	@ApiOperation(value="带附件邮件发送", notes="发送一份带附件的邮件")
	@ApiImplicitParams({
		@ApiImplicitParam(name="toUser", value="接收者", required=true, dataType="String")
	})
	@PostMapping("/attachmentsMail")
	public Map<String, Object> attachmentsMail(@RequestBody String toUser){
		Map<String, Object> map =new HashMap<>();
		MimeMessage  message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(toUser);
			helper.setSubject("带附件邮件");
			FileSystemResource fs = new FileSystemResource(new File("D:\\DownLoad\\file\\阿里巴巴Java开发手册v1.2.0.pdf"));
			helper.setText("这是一封带附件的邮件！");
			helper.addAttachment("阿里巴巴Java开发手册v1.2.0.pdf", fs);
			jms.send(message);
			map.put("res", "success");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("res", "error");
		} catch(MessagingException e) {
			e.printStackTrace();
			map.put("res", "error");
		}
		return map;
	}
	
	@ApiOperation(value="带图片邮件发送", notes="发送一份带图片的邮件")
	@ApiImplicitParams({
		@ApiImplicitParam(name="toUser", value="接收者", required=true, dataType="String")
	})
	@PostMapping("/imgMail")
	public Map<String, Object> imgMail(@RequestBody String toUser){
		Map<String, Object> map =new HashMap<>();
		MimeMessage  message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(toUser);
			helper.setSubject("带图片邮件");
			String content = "<html><body>博客头像<img src='cid:img'/></body></html>";
			helper.setText(content, true);
			FileSystemResource fs = new FileSystemResource(new File("D:\\DownLoad\\img\\20171123181522_c48800.jpg"));
			helper.addInline("img", fs);
			jms.send(message);
			map.put("res", "success");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("res", "error");
		} catch(MessagingException e) {
			e.printStackTrace();
			map.put("res", "error");
		}
		return map;
	}
	
	@ApiOperation(value="模板邮件发送", notes="发送一份模板邮件")
	@ApiImplicitParams({
		@ApiImplicitParam(name="toUser", value="接收者", required=true, dataType="String")
	})
	@PostMapping("/templateMail")
	public Map<String, Object> templateMail(@RequestBody String toUser){
		Map<String, Object> map =new HashMap<>();
		MimeMessage  message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(toUser);
			helper.setSubject("模板邮件");
			Context context = new Context();
			context.setVariable("username", "promise");
			String template = templateEngine.process("/common/EmailTemplate", context);
			helper.setText(template, true);
			jms.send(message);
			map.put("res", "success");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("res", "error");
		} catch(MessagingException e) {
			e.printStackTrace();
			map.put("res", "error");
		}
		return map;
	}
}
