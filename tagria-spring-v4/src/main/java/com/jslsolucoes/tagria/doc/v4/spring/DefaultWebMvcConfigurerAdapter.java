package com.jslsolucoes.tagria.doc.v4.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = { "com.jslsolucoes.tagria.doc.v4.spring.**" })
public class DefaultWebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
	InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
	internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
	internalResourceViewResolver.setSuffix(".jsp");
	return internalResourceViewResolver;
    }

   
}