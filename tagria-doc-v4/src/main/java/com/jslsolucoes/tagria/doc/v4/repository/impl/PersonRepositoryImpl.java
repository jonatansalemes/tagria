
package com.jslsolucoes.tagria.doc.v4.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang3.RandomStringUtils;

import com.jslsolucoes.tagria.doc.v4.model.Person;
import com.jslsolucoes.tagria.doc.v4.repository.PersonRepository;

@ApplicationScoped
public class PersonRepositoryImpl implements PersonRepository {

    private List<Person> pessoas;

    public PersonRepositoryImpl() {
	pessoas = new ArrayList<Person>();
	for (int i = 1; i <= 1000; i++) {
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
	return listAll(20);
    }

    public List<Person> listAll(Integer maxResult) {
	return pessoas.subList(0, maxResult);
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
	return listAll().subList(firstResult, firstResult + maxResult);
    }

}
