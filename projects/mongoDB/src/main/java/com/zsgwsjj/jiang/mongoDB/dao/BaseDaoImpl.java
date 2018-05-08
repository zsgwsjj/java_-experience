package com.zsgwsjj.jiang.mongoDB.dao;

import com.zsgwsjj.jiang.mongoDB.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.persistence.criteria.Order;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author : jiang
 * @time : 2018/4/26 15:12
 */
public abstract class BaseDaoImpl<T> implements IBaseDao<T> {

    protected abstract Class<T> getEntityClass();

    @Autowired
    protected MongoTemplate mgt;

    @Override
    public void save(T entity) {
        mgt.save(entity);
    }

    @Override
    public void update(T entity) {
        Map<String, Object> map = null;
        try {
            map = parseEntity(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idName = null;
        Object idValue = null;

        Update update = new Update();
        if (EmptyUtil.isNotEmpty(map)) {
            for (String key : map.keySet()) {
                if (key.indexOf("{") != -1) {
                    idName = key.substring(key.indexOf("{") + 1, key.indexOf("}"));
                    idValue = map.get(key);
                } else {
                    update.set(key, map.get(key));
                }
            }
        }
        mgt.updateFirst(new Query().addCriteria(where(idName).is(idValue)), update, getEntityClass());
    }

    @Override
    public void delete(Serializable... ids) {
        if (EmptyUtil.isNotEmpty(ids)) {
            for (Serializable id : ids) {
                mgt.remove(mgt.findById(id, getEntityClass()));
            }
        }
    }

    @Override
    public List<T> find(Serializable id) {
        return mgt.findAll(getEntityClass());
    }

//    public List<T> findAll(String order) {
//        List<Order> orders =
//    }

    protected Query createQuery(String[] params, Object[] values, String order) {
        Query query = new Query();
        if (EmptyUtil.isNotEmpty(params) && EmptyUtil.isNotEmpty(values)) {
            for (int i = 0; i < params.length; i++) {
                query.addCriteria(where(params[i]).is(values[i]));
            }
        }
//        List<Order> orderList=
        return null;
    }

    protected List<Order> parseOrder(String order) {
        List<Order> list = null;
        if (EmptyUtil.isNotEmpty(order)) {
            list = new ArrayList<Order>();
            String[] fields = order.split(",");
            Order o = null;
            String[] item = null;
        }
        return null;
    }

    protected Map<String, Object> parseEntity(T t) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        String idName = "";
        Field[] declareFields = getEntityClass().getDeclaredFields();
        for (Field filed : declareFields) {
            if (filed.isAnnotationPresent(Id.class)) {
                map.put("(" + filed.getName() + ")", filed.get(t));
                idName = filed.getName();
                break;
            }
        }
        Method[] methods = getEntityClass().getDeclaredMethods();
        if (EmptyUtil.isNotEmpty(methods)) {
            for (Method method : methods) {
                if (method.getName().startsWith("get") && method.getModifiers() == Modifier.PUBLIC) {
                    String fileName = parse2FileName(method.getName());
                    if (!fileName.equals(idName)) {
                        map.put(fileName, method.invoke(t));
                    }
                }
            }
        }
        return map;
    }

    private String parse2FileName(String methodName) {
        String name = methodName.replace("get", "");
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        return name;
    }
}
