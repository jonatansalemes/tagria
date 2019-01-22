
package com.jslsolucoes.tagria.doc.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang.RandomStringUtils;

import com.jslsolucoes.tagria.doc.model.Pessoa;
import com.jslsolucoes.tagria.doc.repository.PessoaRepository;

@ApplicationScoped
public class PessoaRepositoryImpl implements PessoaRepository {

	private List<Pessoa> pessoas;

	public PessoaRepositoryImpl() {
		pessoas = new ArrayList<Pessoa>();
		for (int i = 1; i <= 20; i++) {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(RandomStringUtils.randomAlphabetic(10));
			pessoa.setDataNascimento(Calendar.getInstance().getTime());
			pessoa.setGostaChocolate((i % 2 == 0 ? 1 : 0));
			pessoa.setCpf(RandomStringUtils.randomNumeric(11));
			pessoa.setCep(RandomStringUtils.randomNumeric(8));
			pessoa.setId(Long.valueOf(i));
			pessoas.add(pessoa);
		}

	}

	public List<Pessoa> listAll() {
		return pessoas;
	}

	@Override
	public Pessoa load(Pessoa pessoa) {
		for (Pessoa load : this.listAll()) {
			if (load.getId().equals(pessoa.getId()))
				return load;
		}
		return null;
	}

	@Override
	public List<Pessoa> listAll(Integer firstResult, Integer maxResult) {
		return pessoas.subList(firstResult, firstResult + maxResult);
	}

}
