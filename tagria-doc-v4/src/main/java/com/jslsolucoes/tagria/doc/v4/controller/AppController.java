
package com.jslsolucoes.tagria.doc.v4.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.RandomStringUtils;

import com.jslsolucoes.jax.rs.server.ee.response.Responses;
import com.jslsolucoes.tagria.doc.v4.model.Person;
import com.jslsolucoes.tagria.doc.v4.repository.PersonRepository;
import com.jslsolucoes.tagria.tag.html.v4.tag.form.FormErrors;

@Path("app")
public class AppController {

    private Models models;
    private PersonRepository personRepository;

    public AppController() {

    }

    @Inject
    public AppController(Models models, PersonRepository personRepository) {
	this.models = models;
	this.personRepository = personRepository;
    }

    @GET
    @Path("playground")
    @View("app/playground.jsp")
    @Controller
    public void playground() {
	this.models.put("booleanValue", Boolean.TRUE);
	this.models.put("person", personRepository.listAll(1).get(0));
	this.models.put("persons", personRepository.listAll(3));
	this.models.put("personsArray", personRepository.listAll(3).toArray(new Person[] {}));
	this.models.put("personsMap",
		personRepository.listAll(3).stream().collect(Collectors.toMap(Person::getId, Person::getName)));
	this.models.put("totalResults", 3);
	this.models.put("dateTime", LocalDateTime.now());
	this.models.put("descriptions", RandomStringUtils.randomNumeric(14));
	this.models.put("myValue", 12345L);
	this.models.put("cpf", 7137389090L);
    }

    @GET
    @Path("benchmark")
    @View("app/benchmark.jsp")
    @Controller
    public void benchmark() {

    }

    @GET
    @Path("autoComplete")
    @View("app/autoComplete.jsp")
    @Controller
    public void autoComplete() {

    }

    @GET
    @Path("home")
    @View("app/home.jsp")
    @Controller
    public void home() {

    }

    @GET
    @Path("template")
    @View("app/template.jsp")
    @Controller
    public void template() {

    }

    @POST
    @Path("form/validation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response formValidation() {
	return Responses.ok(FormErrors.newBuilder().withErrors(Arrays.asList("error1", "error2")).build());
    }

    @POST
    @Path("ajax")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajax(String input1) {
	return Responses.ok(input1);
    }

    @POST
    @Path("ajax/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajaxList() {
	return Responses.ok(personRepository.listAll());
    }

}
