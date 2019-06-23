package com.personal.SampleApplication;

import com.personal.config.DataSourceConfig;
import com.personal.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 * @author : YangChunLong
 * @date : Created in 2019/5/27 23:10
 * @description: Spring boot 项目启动类
 * @modified By:
 * @version: :
 */
@SpringBootApplication
@Import(value = {DataSourceConfig.class, RabbitMqConfig.class})
@ComponentScan(basePackages = {"com.personal"})
public class SampleSpringBootApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootApplicationStarter.class,args);
        System.out.println("项目启动成功！");
    }
}
