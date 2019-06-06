package com.mind.xynbiot.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @program: xynbiot
 * @description: test
 * @author: Mind
 * @create: 2019-05-17 15:24
 **/
@RestController
@RequestMapping("test")
public class TestController {
private static final Logger log = LoggerFactory.getLogger(TestController.class);

@RequestMapping(value = "/test", method = RequestMethod.POST)
@ResponseBody
public JSONObject test(@RequestBody JSONObject jsonObject){
    log.info("【TestController>>>test】{}",jsonObject);


    return null;
}

}
