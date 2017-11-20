package ysq.com.serviceribbon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ysq.com.serviceribbon.service.HelloService;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/20 17:02
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://service-hi/hi?name=" + name, String.class);
    }
}
