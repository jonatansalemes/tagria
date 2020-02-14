package com.jslsolucoes.tagria.config.v4.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tagrialib")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configuration {

    @XmlElementWrapper(name = "templates")
    @XmlElement(name = "template")
    private List<Template> templates = new ArrayList<>();

    @XmlElementWrapper(name = "formatters")
    @XmlElement(name = "formatter")
    private List<Formatter> formatters = new ArrayList<>();

    private Cdn cdn = new Cdn();
    private Security security = new Security();
    private String encoding = "utf-8";
    private String skin = "default";
    private String locale = "en";

    private Warning warning = new Warning();

    public List<Template> getTemplates() {
	return templates;
    }

    public void setTemplates(List<Template> templates) {
	this.templates = templates;
    }

    public List<Formatter> getFormatters() {
	return formatters;
    }

    public void setFormatters(List<Formatter> formatters) {
	this.formatters = formatters;
    }

    public Cdn getCdn() {
	return cdn;
    }

    public void setCdn(Cdn cdn) {
	this.cdn = cdn;
    }

    public String getEncoding() {
	return encoding;
    }

    public void setEncoding(String encoding) {
	this.encoding = encoding;
    }

    public String getSkin() {
	return skin;
    }

    public void setSkin(String skin) {
	this.skin = skin;
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(String locale) {
	this.locale = locale;
    }

    public Warning getWarning() {
	return warning;
    }

    public void setWarning(Warning warning) {
	this.warning = warning;
    }

    public Security getSecurity() {
	return security;
    }

    public void setSecurity(Security security) {
	this.security = security;
    }

}