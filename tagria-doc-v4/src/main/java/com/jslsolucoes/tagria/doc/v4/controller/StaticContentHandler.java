package com.jslsolucoes.tagria.doc.v4.controller;

import java.io.InputStream;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("assets")
public class StaticContentHandler {

    private ServletContext servletContext;

    public StaticContentHandler() {

    }

    @Inject
    public StaticContentHandler(ServletContext servletContext) {
	this.servletContext = servletContext;
    }

    @GET
    @Path("{path:.*}")
    public Response Get(@PathParam("path") String path) {
	InputStream resource = servletContext.getResourceAsStream(String.format("/WEB-INF/assets/%s", path));
	return Objects.isNull(resource) ? Response.status(Status.NOT_FOUND).build()
		: Response.ok().entity(resource).build();
    }
}