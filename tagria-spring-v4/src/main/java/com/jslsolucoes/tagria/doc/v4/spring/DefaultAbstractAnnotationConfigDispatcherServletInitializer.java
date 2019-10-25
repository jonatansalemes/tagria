package com.jslsolucoes.tagria.doc.v4.spring;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DefaultAbstractAnnotationConfigDispatcherServletInitializer
	extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { DefaultWebMvcConfigurerAdapter.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] {};
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {

	return new Filter[] { characterEncodingFilter() };
    }

    private Filter characterEncodingFilter() {
	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	characterEncodingFilter.setEncoding("UTF-8");
	characterEncodingFilter.setForceEncoding(true);
	return characterEncodingFilter;
    }

}