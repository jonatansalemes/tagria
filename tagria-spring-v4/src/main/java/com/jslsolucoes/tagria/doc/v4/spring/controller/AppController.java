package com.jslsolucoes.tagria.doc.v4.spring.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestScope
public class AppController {

    
    @GetMapping("/app/another")
    public ModelAndView another() {
	return new ModelAndView();
    }

    @GetMapping("/app/playground")
    public ModelAndView playground(Model model) {
	model.addAttribute("now",LocalDate.now());
	return new ModelAndView();
    }
    
    @GetMapping("/app/template")
    public ModelAndView template() {
	return new ModelAndView();
    }
    
    @PostMapping("/app/playground/submit")
    public ModelAndView createOrUpdate(@RequestParam LocalDate myDate) {
	System.out.println(myDate);
	return new ModelAndView("redirect:/app/playground");
    }

}