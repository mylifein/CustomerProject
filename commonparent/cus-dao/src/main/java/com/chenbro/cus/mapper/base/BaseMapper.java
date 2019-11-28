package com.chenbro.cus.mapper.base;

/**
 * @version 1.0
 * @ClassName BaseMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 15:43
 **/
public interface BaseMapper<T> {

    public T findById(String id);

    public T findByUUID(String uuid);

    public void deleteById(Integer id);

    public void deleteByUUID(String uuid);

    public void update(T t);

    public void insert(T t);
}
