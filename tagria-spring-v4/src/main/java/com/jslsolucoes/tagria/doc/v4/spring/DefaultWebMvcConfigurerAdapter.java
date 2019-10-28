package com.jslsolucoes.tagria.doc.v4.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jslsolucoes.spring.converter.BigDecimalConverter;
import com.jslsolucoes.spring.converter.IntegerConverter;
import com.jslsolucoes.spring.converter.LocalDateConverter;
import com.jslsolucoes.spring.converter.LocalDateTimeConverter;
import com.jslsolucoes.spring.converter.LongConverter;

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
    
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
	LocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter();
	formatterRegistry.addConverter(new LocalDateConverter(localDateTimeConverter));
	formatterRegistry.addConverter(localDateTimeConverter);
	formatterRegistry.addConverter(new IntegerConverter());
	formatterRegistry.addConverter(new LongConverter());
	formatterRegistry.addConverter(new BigDecimalConverter());
    }

   
}