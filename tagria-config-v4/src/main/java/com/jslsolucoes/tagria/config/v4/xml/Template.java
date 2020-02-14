package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "template")
@XmlAccessorType(XmlAccessType.FIELD)
public class Template {

    private String name;

    private String uri;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "TagriaTemplateXML [name=" + name + ", uri=" + uri + "]";
    }

    public String getUri() {
	return uri;
    }

    public void setUri(String uri) {
	this.uri = uri;
    }

}