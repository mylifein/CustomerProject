package com.chenbro.cus.service.base;

import com.chenbro.cus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 16:48
 **/
public abstract class BaseServiceImpl<T> implements IBaseService<T>{

    //统一管理dao
    @Autowired
    protected UserMapper userMapper;



    @Override
    public T findByUUID(String uuid) {
        return null;
    }


    @Override
    public void deleteByUUID(String uuid) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void insert(T t) {

    }
}
