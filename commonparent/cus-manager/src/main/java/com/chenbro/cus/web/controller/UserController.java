package com.chenbro.cus.web.controller;

import com.chenbro.cus.model.User;
import com.chenbro.cus.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version 1.0
 * @ClassName com.chenbro.cus.web.controller.UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 15:22
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * @param
     * @Author Administrator
     * @Description //登陆功能    users/login  如果登陆失败,跳到登录页面login.jsp  如果登陆成功，跳到主页面main.jsp
     * @Date 18:32 2019/12/3
     * @returnjava.lang.String
     */
    @RequestMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {//当前Subject是否进行认证（登录）
            // 前台用户传入的用户名和密码(将用户名和密码封装到UsernamePasswordToken中)
            User user = userService.selectByUsername(username);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);          //记住我
            try {
                //进行登陆验证
                currentUser.login(token);
            } catch (UnknownAccountException uae) {  //未知账户异常
                model.addAttribute("msg","用户名不存在");
                return "user/login";
            } catch (IncorrectCredentialsException ice) { //凭证匹配器异常  不正确的的凭证异常
                model.addAttribute("msg","密码输入错误");
                return "user/login";
            } catch (LockedAccountException lae) {       //帐户锁定异常  (将来要在业务逻辑中进行判断）
                model.addAttribute("msg","该户名因违规,被锁定 ");
                return "user/login";
            } catch (AuthenticationException ae) {       //认证异常  身份验证异常
                return null;
            }
        }
        System.out.println("璐璐真漂亮");
        return "main";
    }

    /**
     * @Author Administrator
     * @Description //登出功能
     * @Date 13:13 2019/12/11
     * @param
     * @returnjava.lang.String
     */
    @RequestMapping("logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        //all done - log out! 登出
        currentUser.logout();
        return "user/login";
    }

    @RequestMapping("home")
    public String homePage() {
        return "home";
    }
}
