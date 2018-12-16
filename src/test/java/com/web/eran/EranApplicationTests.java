package com.web.eran;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.eran.entity.SysUser;
import com.web.eran.service.ISysUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EranApplicationTests {
	
	@Autowired ISysUserService suMapper;

	private final Logger log = LoggerFactory.getLogger(EranApplicationTests.class);
	
	@Test
	public void contextLoads() {
		SysUser su = suMapper.findByUsername("eran");
		log.info(su.getPassword());
		SysUser su1 = suMapper.findByUsername("eran");
		log.info(su1.getPassword());
		SysUser entity = new SysUser();
		entity.setPassword("123456");
		entity.setUsername("eran");
		entity.setId(1L);
		try {
			System.out.println(suMapper.update(entity));
			SysUser su2 = suMapper.findByUsername("eran");
			log.info(su2.getPassword());
			log.info("----");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
