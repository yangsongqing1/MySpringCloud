package ysq.com.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/20 16:59
 */
public interface HelloService {

    String hiService(String name);
}
