
package com.jslsolucoes.tagria.doc.v4.repository;

import java.util.List;

import com.jslsolucoes.tagria.doc.v4.model.Person;

public interface PersonRepository {

    public List<Person> listAll(Integer size);

    public List<Person> listAll();

    public List<Person> listAll(Integer firstResult, Integer maxResult);

    public Person load(Person pessoa);
}
