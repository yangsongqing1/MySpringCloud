package ysq.com.client.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/20 17:18
 */
@RestController
public class HiController {
    private final static Log log = LogFactory.getLog(HiController.class);
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        log.info("来自天空的日志信息!");
//        throw new RuntimeException("来自天空的异常信息");
        return "hi " + name + ",i am from port:" + port;
    }
}
