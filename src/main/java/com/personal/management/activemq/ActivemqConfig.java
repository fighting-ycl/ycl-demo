package com.personal.management.activemq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/19 21:06
 * @description: activemq 配置类
 * @modified By:
 * @version: :
 */
@Component
@ConfigurationProperties(prefix = "spring.activemq")
public class ActivemqConfig {
    private String broker_url;
    private String user;
    private String password;

    public String getBroker_url() {
        return broker_url;
    }

    public void setBroker_url(String broker_url) {
        this.broker_url = broker_url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
