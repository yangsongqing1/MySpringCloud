package ysq.com.app.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysq.com.app.Base.BaseService;
import ysq.com.app.mapper.UserMapper;
import ysq.com.app.pojo.User;
import ysq.com.app.redis.DistributedLock;
import ysq.com.app.redis.RedisClient;
import ysq.com.app.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/28 13:47
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    int n = 500;
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisClient redis;

    @Autowired
    DistributedLock lock;

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

    @Override
    public void lockTest() {
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA();
            Thread thread = new Thread(threadA);
            thread.start();
        }
    }

    //==========================分布式锁测试==========================//
    private void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        String identifier = lock.lockWithTimeout("resource", 5000, 1000);
        Random random = new Random();
        n--;
        try {
            int s = random.nextInt(50);
            Thread.sleep(s);
            System.out.println("随机===" + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(n);
        lock.releaseLock("resource", identifier);
    }

    public class ThreadA implements Runnable {

        @Override
        public void run() {
            seckill();
        }
    }
}
