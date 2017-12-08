package ysq.com.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 更改配置文件时请求http://localhost:8881/bus/refresh
 * 另外，/bus/refresh接口可以指定服务，即使用"destination"参数
 * 比如 "/bus/refresh?destination=customers:**" 即刷新服务名为customers的所有服务，不管ip
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}
