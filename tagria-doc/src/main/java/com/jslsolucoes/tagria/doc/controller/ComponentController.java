
package com.jslsolucoes.tagria.doc.controller;

import javax.inject.Inject;

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

		if ("grid".equals(component) || "gridColumn".equals(component) || "select".equals(component)
				|| "dataBlock".equals(component)) {
			this.result.include("persons", pessoaRepository.listAll());
		}
		this.result.forwardTo("/WEB-INF/jsp/component/" + component + ".jsp");
	}
}
