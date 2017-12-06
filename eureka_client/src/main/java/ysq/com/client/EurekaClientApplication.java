package ysq.com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * https://www.cnblogs.com/hunttown/p/6768864.html kibana界面操作
 * https://www.elastic.co/downloads
 * logstash,elasticsearch,kibana三件套
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
