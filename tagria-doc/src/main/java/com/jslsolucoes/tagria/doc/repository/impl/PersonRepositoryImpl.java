
package com.jslsolucoes.tagria.doc.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang.RandomStringUtils;

import com.jslsolucoes.tagria.doc.model.Person;
import com.jslsolucoes.tagria.doc.repository.PersonRepository;

@ApplicationScoped
public class PersonRepositoryImpl implements PersonRepository {

	private List<Person> pessoas;

	public PersonRepositoryImpl() {
		pessoas = new ArrayList<Person>();
		for (int i = 1; i <= 20; i++) {
			Person pessoa = new Person();
			pessoa.setName(RandomStringUtils.randomAlphabetic(10));
			pessoa.setBirthDate(Calendar.getInstance().getTime());
			pessoa.setLikeChocolate((i % 2 == 0 ? 1 : 0));
			pessoa.setCpf(RandomStringUtils.randomNumeric(11));
			pessoa.setCep(RandomStringUtils.randomNumeric(8));
			pessoa.setId(Long.valueOf(i));
			pessoas.add(pessoa);
		}

	}

	public List<Person> listAll() {
		return pessoas;
	}

	@Override
	public Person load(Person pessoa) {
		for (Person load : this.listAll()) {
			if (load.getId().equals(pessoa.getId()))
				return load;
		}
		return null;
	}

	@Override
	public List<Person> listAll(Integer firstResult, Integer maxResult) {
		return pessoas.subList(firstResult, firstResult + maxResult);
	}

}
