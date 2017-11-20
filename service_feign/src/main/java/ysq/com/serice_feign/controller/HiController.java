package ysq.com.serice_feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ysq.com.serice_feign.feign.FeignServiceHi;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/20 18:02
 */
@RestController
public class HiController {
    @Autowired
    FeignServiceHi feignServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return feignServiceHi.sayHiFromClientOne(name);
    }
}
