package ysq.com.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ysq.com.ribbon.service.HelloService;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/20 17:04
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloServiceImpl;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloServiceImpl.hiService(name);
    }
}
