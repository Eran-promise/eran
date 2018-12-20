package com.web.eran.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author Promise
* @createTime 2018年12月20日 下午10:22:37
* @description 测试过滤器，拦截器接口
*/
@Api(value="测试过滤器，拦截器接口")
@RestController
public class FilterTextController {

	private static final Logger log = LoggerFactory.getLogger(FilterTextController.class);
	
	@ApiOperation(value="测试过滤器接口", notes="测试过滤器接口")
	@GetMapping("/filter")
	public Map<String, Object> filterTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("res", "success");
		return map;
	}
}
