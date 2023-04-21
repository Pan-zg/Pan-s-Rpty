package com.springboot.springbootlogindemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 解决前后端端口号不一致导致的无法获取数据问题（全局跨域设置问题）
*
* Create by Pan-zg on 2023/04/20
* */
@Configuration
public class GlobalCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfiguration() {
        return new WebMvcConfigurer() {
//            @Override
            public void addCorsMapping(CorsRegistry registry) {
                registry.addMapping("/**")      // 添加映射路径，"/**"表示对所有的路径实行全局跨域访问权限的设置
                        .allowedOriginPatterns("*")    // 开放哪些ip、端口、域名的访问权限 SpringBoot2.4.0以后allowedOrigins被allowedOriginPatterns代替
                        .allowCredentials(true)     // 是否允许发送Cookie信息
                        .allowedMethods("GET", "POST", "PUT", "DELETE")     // 开放哪些Http方法，允许跨域访问
                        .allowedHeaders("*")    // 允许Http请求中携带哪些头（Header）信息
                        .exposedHeaders("*");   // 暴露哪些头信息（跨域访问默认不能获取全部头信息）
            }
        };
    }
}
