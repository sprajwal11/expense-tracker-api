package com.expensetracker.expensetrackerapi;

import com.expensetracker.expensetrackerapi.filters.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class ExpenseTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean(){
		FilterRegistrationBean<AuthFilter> registrationBean=new FilterRegistrationBean<>();
		AuthFilter authFilter=new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/categories/*");
		return registrationBean;

	}
}
