package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "template")
@XmlAccessorType(XmlAccessType.FIELD)
public class Template {

    private String name;

    private String uri;

    private Boolean cached = Boolean.FALSE;
    
    private Boolean ignoreSSL = Boolean.TRUE;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Template [name=" + name + ", uri=" + uri + ", cached=" + cached + "]";
    }

    public String getUri() {
	return uri;
    }

    public void setUri(String uri) {
	this.uri = uri;
    }

    public Boolean getCached() {
	return cached;
    }

    public void setCached(Boolean cached) {
	this.cached = cached;
    }

    public Boolean getIgnoreSSL() {
	return ignoreSSL;
    }

    public void setIgnoreSSL(Boolean ignoreSSL) {
	this.ignoreSSL = ignoreSSL;
    }

}