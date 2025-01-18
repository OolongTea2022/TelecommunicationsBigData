package com.bigdata.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 允许跨域请求的路径
                .allowedOriginPatterns("*")    // 允许所有域名与端口
                .allowCredentials(true) // 允许携带认证信息
                .maxAge(3600)   // 预检请求缓存时间，1小时
                .allowedHeaders("*")    // 允许的请求头
                .allowedMethods("GET", "POST", "PUT", "DELETE");   // 允许的方法
    }
}
