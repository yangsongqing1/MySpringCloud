package ysq.com.serice_feign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ysq.com.serice_feign.feign.hystric.FeignServiceHiHystric;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/11/20 17:58
 */
@FeignClient(value = "service-hi", fallback = FeignServiceHiHystric.class)
public interface FeignServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
