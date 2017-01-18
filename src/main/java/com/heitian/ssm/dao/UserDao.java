package com.heitian.ssm.dao;

import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */

@Repository("UserDao")
public interface UserDao {
    @Select("select * from User")
    public List<User> getAll();

    @Select("select name from User where name=#{name}")
    public  User getUser(User user);

    @Insert("insert into User(name,password,status) values(#{name},#{password},#{status})")
    public void insert(User user);

    @Update("update User set password=#{password} where id=#{id}")
    public void update(int id);

    @Delete("delete from  User where id=#{id}")
    public void delete(int id);

    @Select("select name from User")
    public List getAllName();

    @Select("select * from User where id=#{id}")
    public User getById(int id);

}
