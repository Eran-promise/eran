package com.web.eran.config.aoplog;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.web.eran.entity.SysLog;
import com.web.eran.service.ISysLogService;

/**
* @author Promise
* @createTime 2018年12月18日 下午9:33:28
* @description 切面日志配置
*/
@Aspect
@Component
public class LogAsPect {

	@Autowired
	private ISysLogService sysLogService;
	
	@Pointcut("@annotation(com.web.eran.config.aoplog.Log)")
	public void pointcut() {}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint point) {
		Object result =null;
		long beginTime = System.currentTimeMillis();
		
		try {
			result = point.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		insertLog(point,endTime-beginTime);
		return result;
	}
	
	private void insertLog(ProceedingJoinPoint point ,long time) {
		MethodSignature signature = (MethodSignature)point.getSignature();
		Method method = signature.getMethod();
		SysLog sys_log = new SysLog();
		
		Log userAction = method.getAnnotation(Log.class);
		if (userAction != null) {
			// 注解上的描述
			sys_log.setUserAction(userAction.value());
		}
		
		// 请求的方法名
		String className = point.getTarget().getClass().getName();
		String methodName = signature.getName();
		// 请求的方法参数值
		Object[] args = point.getArgs();
		// 请求的方法参数名称
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paramNames = u.getParameterNames(method);
		if (args != null && paramNames != null) {
			String params = "";
			for (int i = 0; i < args.length; i++) {
				params += "  " + paramNames[i] + ": " + args[i];
			}
		}
		//当前登陆人名称
		Long useride = (Long)SecurityUtils.getSubject().getSession().getAttribute("userid");
		
		sys_log.setUserId(useride);
		sys_log.setCreateTime(new java.sql.Timestamp(new Date().getTime()));
		
		sysLogService.insertLog(sys_log);
	}
}
