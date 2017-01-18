package com.heitian.ssm.service;

import com.heitian.ssm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Repository("UserService")
public interface UserService {
    public List<User> getAll();
    public  User getUser(User user);
    public void insert(User user);
    public void update(int id);
    public void delete(int id);
    public List getAllName();
    public User getById(int id);
}
