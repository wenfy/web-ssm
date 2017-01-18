package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name="UserDao")
    UserDao userDao;
    public List<User> getAll() {

        return userDao.getAll();
    }

    public User getUser(User user) {
        return userDao.getUser(user);
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public void update(int id) {
        userDao.update(id);

    }

    public void delete(int id) {
        userDao.delete(id);

    }

    public List getAllName() {
      return   userDao.getAllName();
    }

    public User getById(int id) {
        return userDao.getById(id);
    }
}