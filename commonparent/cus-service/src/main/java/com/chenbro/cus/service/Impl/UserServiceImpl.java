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
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByUUID(String uuid) {
        return userMapper.findByUUID(uuid);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void deleteByUUID(String uuid) {
        userMapper.deleteByUUID(uuid);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
