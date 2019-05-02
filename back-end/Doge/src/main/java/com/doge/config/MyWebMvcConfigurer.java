package com.doge.config;

import com.doge.interceptor.BackInterceptor;
import com.doge.interceptor.ForeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 配置类
 * @Author: chenjun
 * @Date: 2018/04/12
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    //@Bean注册一个bean，id为方法名
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return converter;
//    }

    //@将拦截器注册为一个bean,解决拦截器中使用@Autowired失败
    @Bean
    public HandlerInterceptor getForeInterceptor() {
        return new ForeInterceptor();
    }

    @Bean
    public HandlerInterceptor getBackInterceptor() {
        return new BackInterceptor();
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(responseBodyConverter());
//    }
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false);
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getBackInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login");
        registry.addInterceptor(getForeInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin", "/admin/**", "/js/**", "/css/**", "/img/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("fore/index.html");
        registry.addViewController("/toLogin").setViewName("ayigu/login.html");
    }
}



