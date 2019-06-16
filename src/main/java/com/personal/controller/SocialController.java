package com.personal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : YangChunLong
 * @date : Created in 2019/5/27 23:15
 * @description: 控制层
 * @modified By:
 * @version: :
 */
@Controller
public class SocialController {
    private static final Logger logger = LoggerFactory.getLogger(SocialController.class);
    @ResponseBody
    @RequestMapping(value = "/helloWord",method = RequestMethod.GET)
    public String testStart(){
        logger.warn("Hello 日志！");
        return "Hello Spring Boot ! ";
    }
}
