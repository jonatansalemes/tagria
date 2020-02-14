
package com.jslsolucoes.tagria.doc.v4.model;

import java.util.Date;

public class Person {
    private Long id;
    private String name;
    private Date birthDate;
    private Integer likeChocolate = 0;
    private String cpf;
    private String cep;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
    }

    public Integer getLikeChocolate() {
	return likeChocolate;
    }

    public void setLikeChocolate(Integer likeChocolate) {
	this.likeChocolate = likeChocolate;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	this.cep = cep;
    }

}
