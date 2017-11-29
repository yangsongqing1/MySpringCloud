package ysq.com.app.redis;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;
import ysq.com.app.utils.KryoUtil;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/29 11:05
 */
@Component
public class RedisClient {
    private static final Log log = LogFactory.getLog(RedisClient.class);
    @Autowired
    private JedisCluster jedisCluster;

    @Autowired
    private RedisProperties redisProperties;

    private static final String KEY_SPLIT = "_"; //用于隔开缓存前缀与缓存键值

    /**
     * 设置缓存
     *
     * @param prefix 缓存前缀（用于区分缓存，防止缓存键值重复）
     * @param key    缓存key
     * @param object 缓存value
     */
    public void set(String prefix, String key, Object object) {
        try {
            byte[] serialKey = (prefix + KEY_SPLIT + key).getBytes();
            byte[] serialValue = KryoUtil.writeToByteArray(object);
            jedisCluster.set(serialKey, serialValue);
        } catch (Exception e) {
            log.error("redis set操作异常:{}", e);
        }
    }

    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param prefix
     * @param key
     * @param object
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String prefix, String key, Object object, int expireTime) {
        try {
            byte[] serialKey = (prefix + KEY_SPLIT + key).getBytes();
            byte[] serialValue = KryoUtil.writeToByteArray(object);
            jedisCluster.setex(serialKey, expireTime, serialValue);
        } catch (Exception e) {
            log.error("redis setWithExpireTime操作异常:{}", e);
        }
    }

    /**
     * 设置缓存，并且由配置文件指定过期时间
     *
     * @param prefix
     * @param key
     * @param object
     */
    public void setWithExpireTime(String prefix, String key, Object object) {
        try {
            int EXPIRE_SECONDS = redisProperties.getTimeout();
            byte[] serialKey = (prefix + KEY_SPLIT + key).getBytes();
            byte[] serialValue = KryoUtil.writeToByteArray(object);
            jedisCluster.setex(serialKey, EXPIRE_SECONDS, serialValue);
        } catch (Exception e) {
            log.error("redis setWithExpireTime操作异常:{}", e);
        }
    }

    /**
     * 获取指定key的缓存
     *
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String prefix, String key) {
        try {
            if (StringUtils.isNotEmpty(key)) {
                byte[] value = jedisCluster.get((prefix + KEY_SPLIT + key).getBytes());
                if (null != value && value.length != 0) {
                    T kryoObj = KryoUtil.readFromByteArray(value);
                    return kryoObj;
                }
            }
        } catch (Exception e) {
            log.error("redis get异常信息:{}", e);
        }
        return null;
    }

    /**
     * 删除带前辍指定key的缓存
     *
     * @param prefix
     * @param key
     */
    public void deleteWithPrefix(String prefix, String key) {
        jedisCluster.del(prefix + KEY_SPLIT + key);
    }

    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        jedisCluster.del(key);
    }
}
