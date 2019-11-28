package com.chenbro.cus.service.base;

/**
 * @version 1.0
 * @ClassName IBaseService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/27 16:42
 **/
public interface IBaseService<T > {

    public T findById(String id);

    public T findByUUID(String uuid);

    public void deleteById(Integer id);

    public void deleteByUUID(String uuid);

    public void update(T t);

    public void insert(T t);
}
