package ysq.com.serice_feign.feign.hystric;

import org.springframework.stereotype.Component;
import ysq.com.serice_feign.feign.FeignServiceHi;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/21 11:12
 */
@Component
public class FeignServiceHiHystric implements FeignServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
