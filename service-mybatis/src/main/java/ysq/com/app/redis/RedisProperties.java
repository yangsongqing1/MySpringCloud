package ysq.com.app.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Describle: redis集群配置
 * @Author: yangsongqing
 * @Date: 2017/11/29 10:54
 */
@Component
@ConfigurationProperties(prefix = "redis.pool")
@PropertySource("classpath:redis.properties")
public class RedisProperties {
    //redis集群节点
    private String nodes;
    //连接超时时间
    private int timeout;
    //重连次数
    private int maxAttempts;

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
}
