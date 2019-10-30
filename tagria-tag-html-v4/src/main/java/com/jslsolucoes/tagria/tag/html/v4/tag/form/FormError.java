package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import java.util.List;

public class FormError {

    private final List<String> errors;

    public FormError(final List<String> errors) {
	this.errors = errors;
    }

    public List<String> getErrors() {
	return errors;
    }

}
