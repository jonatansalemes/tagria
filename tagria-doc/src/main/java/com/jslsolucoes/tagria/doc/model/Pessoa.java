
package com.jslsolucoes.tagria.doc.model;

import java.util.Date;

public class Pessoa {
	private Long id;
	private String nome;
	private Date dataNascimento;
	private Integer gostaChocolate = 0;
	private String cpf;
	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setGostaChocolate(Integer gostaChocolate) {
		this.gostaChocolate = gostaChocolate;
	}

	public Integer getGostaChocolate() {
		return gostaChocolate;
	}
}
