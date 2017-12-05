package ysq.com.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * http://www.cnblogs.com/shunyang/p/7011283.html
 * http://blog.csdn.net/yejingtao703/article/details/78318234
 * Elasticsearch存储方式需要启动一个spark job来展示依赖关系
 * dependency下zipkin-dependencies.jar
 * STORAGE_TYPE=elasticsearch ES_HOSTS=127.0.0.1:9200 java -jar zipkin-dependencies-1.6.1.jar
 */
@SpringBootApplication
@EnableZipkinStreamServer// //使用Stream方式启动ZipkinServer
@EnableEurekaClient
public class ServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerZipkinApplication.class, args);
    }
}
