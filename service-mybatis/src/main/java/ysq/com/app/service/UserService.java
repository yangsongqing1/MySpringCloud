package ysq.com.app.service;

import ysq.com.app.pojo.User;

import java.util.List;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/28 13:46
 */
public interface UserService {
    List<User> findByName(String name);

    List<User> findAll();

    void lockTest();
}
