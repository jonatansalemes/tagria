
package com.jslsolucoes.tagria.doc.v4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.jslsolucoes.tagria.doc.v4.model.Person;
import com.jslsolucoes.tagria.doc.v4.repository.PersonRepository;


@Path("component")
public class ComponentController {

    private Models models;
    private PersonRepository personRepository;

    public ComponentController() {

    }

    @Inject
    public ComponentController(Models models, PersonRepository personRepository) {
	this.models = models;
	this.personRepository = personRepository;
    }

    @GET
    @Path("{component}")    
    @Controller
    public Response component(@PathParam("component") String component) {
	List<Person> persons = personRepository.listAll();
	this.models.put("persons", persons);
	this.models.put("totalResults", persons.size());
	return Response.ok().entity("component/" + component + ".jsp").build();
    }
}
