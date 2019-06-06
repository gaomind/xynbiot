package com.mind.xynbiot.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: xynbiot
 * @description: NBIot
 * @author: Mind
 * @create: 2019-05-17 16:47
 **/
@RequestMapping("api/")
@RestController
public class NBIotController {
    private static final Logger log = LoggerFactory.getLogger(NBIotController.class);
    @RequestMapping(value = "Device/rptstat", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject rptstat(String mac,String imei,String lockstat,String power,HttpServletRequest request){
       // log.info("【NBIotController>>>test】{}",jsonObject);
        log.info("【NBIotController>>>rptstat】mac={},imei={},lockstat={},power={}",mac,imei,lockstat,power);
        return null;
    }



    @RequestMapping(value = "Bedorder/queryauth", method = RequestMethod.POST)
    @ResponseBody
    public void queryauth(String mac,HttpServletResponse response) throws IOException {
        log.info("【NBIotController>>>queryauth】mac={}",mac);
        response.setContentLength(1);
        PrintWriter writer = response.getWriter();
        //可以开锁返回0
        writer.write("0");

    }


    @RequestMapping(value = "/General/timesync", method = RequestMethod.POST)
    @ResponseBody
    public void timesync(HttpServletResponse response) throws IOException {
        log.info("【NBIotController>>>timesync】{}","时间同步");
       // response.setCharacterEncoding("utf-8");
       // response.setContentType("application/json; charset=utf-8");
        response.setContentLength(18);
        PrintWriter writer = response.getWriter();
        //时间戳
        StringBuilder sb = new StringBuilder(String.valueOf(System.currentTimeMillis()/1000));
        //同步时间
        sb.append(",7").append(",22");
        //报警
        sb.append(",20");
        log.info("【NBIotController>>>timesync】同步响应数据{}",sb.toString());
        writer.write(sb.toString());


    }
}
