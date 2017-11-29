package ysq.com.app.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysq.com.app.Base.BaseService;
import ysq.com.app.mapper.UserMapper;
import ysq.com.app.pojo.User;
import ysq.com.app.redis.RedisClient;
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

    @Autowired
    RedisClient redis;

    @Override
    public List<User> findByName(String name) {
        log.info("分页查询user");
        List<User> list = redis.get("test", "userList");
        if (null == list) {
            PageHelper.startPage(1, 4);
            list = userMapper.findByName(name);
            redis.set("test", "userList", list);
        }
        return list;
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
