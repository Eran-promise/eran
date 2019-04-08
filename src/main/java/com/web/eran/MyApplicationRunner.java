package com.web.eran;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.web.eran.entity.SysPermission;
import com.web.eran.service.ISysPermissionService;

/**
* @author Promise
* @createTime 2019年4月8日 下午1:23:21
* @description 扫描权限配置文件入库
*/
@Component
public class MyApplicationRunner implements ApplicationRunner{
	
	@Autowired
	private ISysPermissionService permissionService;
	
	@Value("${permission.scan}")
	private boolean permissionScan;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		if(permissionScan) {
			SAXReader reader = new SAXReader();
			try {
				//读取xml文件
				Document doc = reader.read(this.getClass().getResourceAsStream("/permission/permission.xml"));
				//获取根节点
				Element rootElement = doc.getRootElement();
				List<SysPermission> list = new ArrayList<>();
				elementParse(rootElement, list);
				permissionService.deleteBySelect(null);
				permissionService.insertByList(list);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void elementParse(Element element, List<SysPermission> list) {
		if(element !=null) {
			if(element.attribute("root") == null) {
				SysPermission permission = new SysPermission();
				String code = element.attributeValue("code");
				permission.setName(element.attributeValue("name"));
				permission.setPercode(code);
				permission.setUrl(element.attributeValue("url"));
				permission.setType(element.attributeValue("type"));
				permission.setAvailable("1");
				if(code !=null && code.length()>3) {//表明该节点存在父节点
					permission.setParentid(code.substring(0, code.length()-2));
				}
				list.add(permission);
			}
			List<Element> elements = element.elements();
			for(Element e : elements) {
				elementParse(e,list);
			}
		}
	}

}
