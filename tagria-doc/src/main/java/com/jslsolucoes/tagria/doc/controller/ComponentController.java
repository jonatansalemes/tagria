
package com.jslsolucoes.tagria.doc.controller;

import java.util.List;

import javax.inject.Inject;

import com.jslsolucoes.tagria.doc.model.Person;
import com.jslsolucoes.tagria.doc.repository.PersonRepository;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path("component")
public class ComponentController {

	private Result result;
	private PersonRepository pessoaRepository;

	public ComponentController() {

	}

	@Inject
	public ComponentController(Result result, PersonRepository pessoaRepository) {
		this.result = result;
		this.pessoaRepository = pessoaRepository;
	}

	@Path("{component}")
	public void component(String component) {
		List<Person> persons = pessoaRepository.listAll();
		this.result.include("persons", persons);
		this.result.include("totalResults", persons.size());
		this.result.forwardTo("/WEB-INF/jsp/component/" + component + ".jsp");
	}
}
