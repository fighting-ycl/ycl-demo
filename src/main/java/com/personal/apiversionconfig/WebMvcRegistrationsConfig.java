package com.personal.apiversionconfig;


import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author : YangChunLong
 * @date : Created in 2019/6/21 22:13
 * @description: web 适配器 注册
 * @modified By:
 * @version: :
 */
@Configuration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiVersioningRequestMappingHandlerMapping();
    }
}
