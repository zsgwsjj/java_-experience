package com.zsgwsjj.jiang.mongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author : jiang
 * @time : 2018/4/26 14:01
 */
@Document(collection = "coll_user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field
    private String name;

    @Field("myage")
    private int age;

    @Indexed(name = "index_birth", direction = IndexDirection.DESCENDING)
    @Field
    private Timestamp birth;

    public String getId() {
        return id;
    }

    public UserInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public UserInfo setBirth(Timestamp birth) {
        this.birth = birth;
        return this;
    }
}
