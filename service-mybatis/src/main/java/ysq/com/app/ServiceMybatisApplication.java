package ysq.com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * http://blog.csdn.net/isea533/article/details/50359390
 * http://blog.csdn.net/catoop/article/details/50684676
 * http://blog.csdn.net/ylimh_hmily/article/details/78287382?utm_source=debugrun&utm_medium=referral
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMybatisApplication.class, args);
    }
}
