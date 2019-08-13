
package com.jslsolucoes.tagria.doc.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.LocalDate;

import com.jslsolucoes.tagria.doc.repository.PersonRepository;
import com.jslsolucoes.vaptor4.misc.annotation.Paginate;
import com.jslsolucoes.vaptor4.misc.pagination.Paginator;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class AppController {

	private Result result;
	private PersonRepository pessoaRepository;
	private Paginator paginator;
	private HttpServletRequest httpServletRequest;

	public AppController() {

	}

	@Inject
	public AppController(Result result, PersonRepository pessoaRepository,HttpServletRequest httpServletRequest) {
		this.result = result;
		this.pessoaRepository = pessoaRepository;
		this.httpServletRequest = httpServletRequest;
	}

	@Path("/")
	public void index() {

	}
	
	@Path("/app/playground")
	@Paginate
	public void playground() {
		
		Integer maxResults = httpServletRequest.getParameter("resultsPerPage") == null ? 60 : Integer.valueOf(httpServletRequest.getParameter("resultsPerPage"));
		Integer firstResult = httpServletRequest.getParameter("page") == null ? 0 : Integer.valueOf(httpServletRequest.getParameter("page")) * maxResults;
		
		this.result.include("booleanValue",Boolean.TRUE);
		this.result.include("persons", pessoaRepository.listAll(firstResult,maxResults));
		this.result.include("dateTime" , LocalDate.now());
		this.result.include("myValue",12345L);
	}

	@Path("/app/welcome")
	public void welcome() {

	}

	@Path("/app/ajax")
	public void ajax(String input1) {
		this.result.use(Results.json()).from(input1, "field").serialize();
	}

	@Path("/app/ajax/list")
	public void ajaxList() {
		this.result.use(Results.json()).from(pessoaRepository.listAll()).serialize();
	}

	@Path("/app/autoComplete")
	public void autoComplete() {
		this.result.use(Results.json()).from(pessoaRepository.listAll()).serialize();
	}

}
