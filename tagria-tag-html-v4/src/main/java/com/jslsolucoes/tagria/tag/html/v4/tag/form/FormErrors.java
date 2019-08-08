package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import java.util.List;

public class FormErrors {

	private List<String> errors;

	private FormErrors() {

	}

	public static FormErrors newBuilder() {
		return new FormErrors();
	}

	public FormErrors withErrors(List<String> errors) {
		this.errors = errors;
		return this;
	}

	public FormErrors build() {
		return this;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
