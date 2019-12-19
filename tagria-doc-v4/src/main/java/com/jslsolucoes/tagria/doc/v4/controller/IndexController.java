package com.jslsolucoes.tagria.doc.v4.controller;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class IndexController {

    @GET
    @Controller
    public String index() {
	return "redirect:/app/home";
    }
}