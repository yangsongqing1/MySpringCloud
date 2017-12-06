package ysq.com.app.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.exceptions.JedisException;

import java.util.UUID;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/12/6 16:03
 */
@Component
public class DistributedLock {

    private static final Log log = LogFactory.getLog(RedisClient.class);
    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 加锁
     *
     * @param lockName       锁的key
     * @param acquireTimeout 获取超时时间
     * @param timeout        锁的超时时间
     * @return 锁标识
     */
    public String lockWithTimeout(String lockName, long acquireTimeout, long timeout) {
        String retIdentifier = null;
        try {
            // 随机生成一个value
            String identifier = UUID.randomUUID().toString();
            // 锁名，即key值
            String lockKey = "lock:" + lockName;
            // 超时时间，上锁后超过此时间则自动释放锁
            int lockExpire = (int) (timeout / 1000);
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;
            while (System.currentTimeMillis() < end) {
                if (jedisCluster.setnx(lockKey, identifier) == 1) {
                    jedisCluster.expire(lockKey, lockExpire);
                    // 返回value值，用于释放锁时间确认
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                // 返回-1代表key没有设置超时时间，为key设置一个超时时间
                if (jedisCluster.ttl(lockKey) == -1) {
                    jedisCluster.expire(lockKey, lockExpire);
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            log.info("加锁失败！", e);
        }
        return retIdentifier;
    }

    /**
     * 释放锁
     *
     * @param lockName   锁的key
     * @param identifier 释放锁的标识
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;
        try {
            while (true) {
                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                if (identifier.equals(jedisCluster.get(lockKey))) {
                    jedisCluster.del(lockKey);
                    retFlag = true;
                }
                break;
            }
        } catch (JedisException e) {
            log.info("释放锁失败！", e);
        }
        return retFlag;
    }
}
