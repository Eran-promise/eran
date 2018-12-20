package com.web.eran.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;


/**
* @author Promise
* @createTime 2018年12月20日 下午10:15:08
* @description 获取方法的执行时间
*/
@Component
@WebFilter(urlPatterns= {"/myf/**"})
public class MethodTimesFilter implements Filter{
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(MethodTimesFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("starting timeFilter");
		Long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long endTime = System.currentTimeMillis();
		log.info("pay time :{}",endTime - startTime);
	}

}
