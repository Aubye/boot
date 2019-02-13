package com.app.index.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class IndexWebMvcConfigurer extends WebMvcConfigurationSupport {

//    @Value("classpath:/static/index.html")
//    private Resource indexHtml;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//    }
//
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public CharacterEncodingFilter characterEncodingFilter() {
//        return new CharacterEncodingFilter("UTF-8", true);
//    }
//
//    @Bean
//    public ServletRegistrationBean apiV1ServletBean(WebApplicationContext wac) {
//        DispatcherServlet servlet = new DispatcherServlet(wac);
//        ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/api/v1/*");
//        bean.setName("api-v1");
//        return bean;
//    }
//
//    @RequestMapping("/")
//    public Object index() {
//        return ResponseEntity.ok().body(indexHtml);
//    }
}
