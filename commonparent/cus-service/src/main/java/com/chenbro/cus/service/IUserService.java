package com.chenbro.cus.service;

import com.chenbro.cus.model.User;
import com.chenbro.cus.service.base.IBaseService;

/**
 * @version 1.0
 * @ClassName IUserService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 16:55
 **/
public interface IUserService extends IBaseService<User> {

    //特有的方法
    public User login(String username,String password);

    User selectByUsername(String username);
}
