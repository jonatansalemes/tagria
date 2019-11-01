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

    public FormError build() {
	return new FormError(errors);
    }

}
