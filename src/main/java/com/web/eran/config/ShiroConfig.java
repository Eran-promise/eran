package com.web.eran.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.eran.shiro.MyFormAuthenticationFilter;
import com.web.eran.shiro.MyShiroRealm;
import com.web.eran.shiro.MyUsernamePasswordToken;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;

/**
* @author Promise
* @createTime 2018年12月4日 下午11:04:56
* @description shiro 配置类
*/
@Configuration
public class ShiroConfig {
	
	private final Logger log = LoggerFactory.getLogger(ShiroConfig.class);

	@Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        log.info("get in shiro config class!!");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> map =new HashMap<>();
        map.put("authc", myFormAuthenticationFilter());
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断(静态文件可以匿名访问)
        filterChainDefinitionMap.put("/statics/**", "anon");
        //生成验证码可以匿名访问
        filterChainDefinitionMap.put("/kaptcha/**", "anon");
        //Actuator监控服务可以匿名访问
        filterChainDefinitionMap.put("/actuator/**", "anon");
        //配置记住我和认证成功可以访问的url
        filterChainDefinitionMap.put("/", "user");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接(就算设置了也没用，shiro会先找"/"路径的controller，如果找不到则匹配templates下面的index.html页面)
        shiroFilterFactoryBean.setSuccessUrl("/index.do");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //注册自定义的拦截器
        shiroFilterFactoryBean.setFilters(map);
        return shiroFilterFactoryBean;
    }

	/**
	 * 注册自定义的realm
	 * @return
	 */
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //注入自定义的realm
        securityManager.setRealm(myShiroRealm());
        //注入记住我管理器
        securityManager.setRememberMeManager(rememberMeMannger());
        return securityManager;
    }
    
    /**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	
	/**
	 * 自定义过滤器，实现验证码功能
	 * @return
	 */
	@Bean
	public MyFormAuthenticationFilter myFormAuthenticationFilter() {
		return new MyFormAuthenticationFilter();
	}
	
	/**
	 * 取消spring对自定义filter的注册
	 * @param myFormAuthenticationFilter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<MyFormAuthenticationFilter> registrationBean(MyFormAuthenticationFilter myFormAuthenticationFilter){
		FilterRegistrationBean<MyFormAuthenticationFilter> registration = new FilterRegistrationBean<MyFormAuthenticationFilter>(myFormAuthenticationFilter);
		registration.setEnabled(false);
		return registration;
	}
	
	/**
	 * cookie对象
	 * @return
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
		//创建cookie，名称为‘rememberMe’
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		//设置cookie生命周期时间
		simpleCookie.setMaxAge(259200);
		return simpleCookie;
	}
	
	/**
	 * cookie 管理对象
	 * @return
	 */
	@Bean
	public CookieRememberMeManager rememberMeMannger() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		//cookie加密的密钥
		cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
		return cookieRememberMeManager;
 	}
}
