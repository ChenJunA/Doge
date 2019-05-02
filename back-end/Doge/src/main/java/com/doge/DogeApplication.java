package com.doge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
//启用Swagger2,也可以放在Swagger2配置类中
@EnableSwagger2
//在Mapper.java使用@Mapper
@MapperScan("com.doge.mapper")
//
@ServletComponentScan
public class DogeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogeApplication.class, args);
	}

}
