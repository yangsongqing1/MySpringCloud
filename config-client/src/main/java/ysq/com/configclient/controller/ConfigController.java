package ysq.com.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/21 17:50
 */
@RestController
public class ConfigController {
    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }
}
