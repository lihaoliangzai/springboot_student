package com.qf.springboot_student;

import com.qf.filter.MyFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
public class SpringbootStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudentApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean getFilter(){
		FilterRegistrationBean f=new FilterRegistrationBean();
		f.setName("MyFilter");
		f.setFilter(new MyFilter());
		f.addUrlPatterns("/*");
		return f;
	}
}
