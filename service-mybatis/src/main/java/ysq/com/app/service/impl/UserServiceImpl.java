package ysq.com.app.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysq.com.app.Base.BaseService;
import ysq.com.app.mapper.UserMapper;
import ysq.com.app.pojo.User;
import ysq.com.app.service.UserService;

import java.util.List;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/28 13:47
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findByName(String name) {
        PageHelper.startPage(1, 4);
        List<User> list = userMapper.findByName(name);
        return list;
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
