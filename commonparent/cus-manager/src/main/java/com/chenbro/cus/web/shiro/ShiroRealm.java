package com.chenbro.cus.web.shiro;

import com.chenbro.cus.model.User;
import com.chenbro.cus.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @ClassName ShiroRealm
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/30 16:24
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
     private IUserService iUserService;

    /**
     * @Author Administrator
     * @Description //授权
     * @Date 13:20 2019/12/2
     * @param principalCollection
     * @returnorg.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    
    /**
     * @Author Administrator
     * @Description // 1.访方法什么情况下会被调用  currentUser.login(token)   2.该方法的入参是什么数据   UsernamePasswordToken
     * @Date 13:19 2019/12/2
     * @param authenticationToken
     * @returnorg.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println(authenticationToken);
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //1. 得到用户输入的用户名
        String username = upToken.getUsername();

        //2. 判断当前用户名在数据库中是否存在
        User user = iUserService.selectByUsername(username);

        //3.如果用户名不存在  UnknowAccountException
        if(user == null){
            throw new UnknownAccountException("用户名不存在");
        }

        //4.如果用户的状态  锁定 LockedAccountException  status = 0  锁定，1 正常
        if(user.getDelFlag().equals("0")){
            throw new LockedAccountException("该帐户已被锁定");
        }
        //5.密码的比较(前台的密码与数据库查询的密码比较 Shiro内部来完成
        //Object principal, Object credentials, String realmName
        Object principal = username;
        Object credentials = user.getPassWord();  // 数据库查询出的密码
        AuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,super.getName());
        return info;
    }
}
