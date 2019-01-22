
package com.jslsolucoes.tagria.doc.generator;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("attribute")
public class Attribute {

	private String name;

	private String rtexprvalue;

	private String type;

	private Boolean required;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRtexprvalue() {
		return rtexprvalue;
	}

	public void setRtexprvalue(String rtexprvalue) {
		this.rtexprvalue = rtexprvalue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
