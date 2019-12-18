
package com.jslsolucoes.tagria.doc.v4.generator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attribute")
@XmlAccessorType(XmlAccessType.FIELD)
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
