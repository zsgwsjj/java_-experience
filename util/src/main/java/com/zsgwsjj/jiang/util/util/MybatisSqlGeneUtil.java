package com.zsgwsjj.jiang.util.util;

import java.lang.reflect.Field;

/**
 * @author : jiang
 * @time : 2018/4/13 16:50
 */
public class MybatisSqlGeneUtil {

    public static String geneInsert(Object object, String table) throws Exception {
        Class clazz = Class.forName(object.getClass().getName());
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder(" INSERT INTO " + table);
        StringBuilder sb2 = new StringBuilder(" ( ");
        StringBuilder sb3 = new StringBuilder(" ( ");
        for (int i = 0; i < fields.length; i++) {
            sb2.append(fields[i].getName());
            if (i < fields.length - 1) {
                sb2.append(",");
            }
            sb3.append(" #{").append(fields[i].getName()).append("}");
            if (i < fields.length - 1) {
                sb3.append(",");
            }
        }
        sb2.append(" ) ");
        sb3.append(" ) ");
        sb = sb.append(sb2.append(" VALUES ").append(sb3));
        return sb.toString();
    }

}
