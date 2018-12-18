package com.web.eran.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.eran.entity.SysRole;
import com.web.eran.entity.SysUser;
import com.web.eran.service.ISysUserService;

import javax.annotation.Resource;

/**
 * @author Promise
 * @createTime 2018年12月4日 下午11:18:24
 * @description 
 */
public class MyShiroRealm extends AuthorizingRealm {
	
	private final Logger log = LoggerFactory.getLogger(MyShiroRealm.class);
	
    @Resource
    private ISysUserService SysUserService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        SysUser SysUser  = (SysUser)principals.getPrimaryPrincipal();
//        for(SysRole role:SysUser.getRoleList()){
//            authorizationInfo.addRole(role.getRole());
//            for(SysPermission p:role.getPermissions()){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        log.info("get in myRealm AuthenticationInfo!!");
        //将参数token转化为自定义的token
        MyUsernamePasswordToken my_token = (MyUsernamePasswordToken) token;
        //获取表单提交内容中验证码
        String vercode_form = my_token.getVercode();
        //获取session中的vercode
        String vercode_session = (String)SecurityUtils.getSubject().getSession().getAttribute("vercode");
        //判断验证码是否正确
        if(!vercode_form.equals(vercode_session))
        	throw new KaptchaErrorException();//如果验证码错误则抛出自定义的异常
        //获取用户的输入的账号.
        String username = my_token.getUsername();
        //通过username从数据库中查找 User对象，如果找到继续执行，没找到.返回null
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser SysUser = SysUserService.findByUsername(username);
        log.info("----->>SysUser="+SysUser);
        if(SysUser == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                SysUser.getPassword(), //密码
//                ByteSource.Util.bytes(SysUser.getSalt()),
                this.getName()  //realm name
        );
        
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("username", username);
        session.setAttribute("userid", SysUser.getId());
        return authenticationInfo;
    }

}
