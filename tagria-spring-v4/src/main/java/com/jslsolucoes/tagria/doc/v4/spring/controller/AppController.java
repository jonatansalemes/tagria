package com.jslsolucoes.tagria.doc.v4.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestScope
public class AppController {

    
    @GetMapping("/app/welcome")
    public ModelAndView welcome() {
	return new ModelAndView();
    }
    
    @GetMapping("/app/template")
    public ModelAndView template() {
	return new ModelAndView();
    }

}