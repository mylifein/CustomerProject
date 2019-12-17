package com.chenbro.cus.service.Impl;

import com.chenbro.cus.model.User;
import com.chenbro.cus.service.IUserService;
import com.chenbro.cus.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 16:57
 **/
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {


    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }


    @Override
    public User findByUUID(String uuid) {
        return userMapper.selectByPrimaryKey(uuid);
    }



    @Override
    public void deleteByUUID(String uuid) {
        userMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
