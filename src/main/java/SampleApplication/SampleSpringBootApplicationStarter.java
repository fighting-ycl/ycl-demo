package SampleApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : YangChunLong
 * @date : Created in 2019/5/27 23:10
 * @description: Spring boot 项目启动类
 * @modified By:
 * @version: :
 */
@SpringBootApplication
@ComponentScan(basePackages = {"java"})
public class SampleSpringBootApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(SampleSpringBootApplicationStarter.class,args);
        System.out.println("项目启动成功！");
    }
}
