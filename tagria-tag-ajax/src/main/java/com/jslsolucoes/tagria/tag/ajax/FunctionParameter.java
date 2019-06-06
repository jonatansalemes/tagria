package com.jslsolucoes.tagria.tag.ajax;

public class FunctionParameter {
	private String name;
	private Boolean required;
	private String value;

	public FunctionParameter(String name, Boolean required, String value) {
		this.name = name;
		this.required = required;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
