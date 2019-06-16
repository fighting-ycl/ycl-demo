package com.personal.controller;

import com.personal.service.RabbitProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : YangChunLong
 * @date : Created in 2019/5/27 23:15
 * @description: 控制层
 * @modified By:
 * @version: :
 */
@Controller
@RequestMapping("/ycl")
public class SocialController {
    private static final Logger logger = LoggerFactory.getLogger(SocialController.class);
    @Autowired
    private RabbitProductService rabbitProductService;
    @ResponseBody
    @RequestMapping(value = "/helloWord",method = RequestMethod.GET)
    public String testStart(){
        logger.warn("Hello 日志！");
        return "Hello Spring Boot ! ";
    }

    @ResponseBody
    @RequestMapping(value = "/testRabbit",method = RequestMethod.GET)
    public String testRabbitMq (@RequestParam(value = "msg")String msg){
        rabbitProductService.sendMsg(msg);
        return "发送成功!";
    }
}
