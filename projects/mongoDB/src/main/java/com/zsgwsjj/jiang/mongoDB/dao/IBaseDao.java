package com.zsgwsjj.jiang.mongoDB.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/4/26 15:14
 */
public interface IBaseDao<T> {
    void save(T entity);

    void update(T entity);

    void delete(Serializable... ids);

    List<T> find(Serializable id);
}
