
package com.jslsolucoes.tagria.doc.repository;

import java.util.List;

import com.jslsolucoes.tagria.doc.model.Person;

public interface PersonRepository {
	public List<Person> listAll();

	public List<Person> listAll(Integer firstResult, Integer maxResult);

	public Person load(Person pessoa);
}
