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
public class TagriaXML {

    @XmlElementWrapper(name = "templates")
    @XmlElement(name = "template")
    private List<TagriaTemplateXML> templates = new ArrayList<>();

    @XmlElementWrapper(name = "formatters")
    @XmlElement(name = "formatter")
    private List<TagriaFormatterXML> formatters = new ArrayList<>();

    private TagriaCdnXML cdn = new TagriaCdnXML();
    private TagriaSecurityXML security = new TagriaSecurityXML();
    private String encoding = "utf-8";
    private String skin = "default";
    private String locale = "en";
    
    private TagriaWarningXML warning = new TagriaWarningXML();

    public List<TagriaTemplateXML> getTemplates() {
	return templates;
    }

    public void setTemplates(List<TagriaTemplateXML> templates) {
	this.templates = templates;
    }

    public List<TagriaFormatterXML> getFormatters() {
	return formatters;
    }

    public void setFormatters(List<TagriaFormatterXML> formatters) {
	this.formatters = formatters;
    }

    public TagriaCdnXML getCdn() {
	return cdn;
    }

    public void setCdn(TagriaCdnXML cdn) {
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

    public TagriaWarningXML getWarning() {
	return warning;
    }

    public void setWarning(TagriaWarningXML warning) {
	this.warning = warning;
    }

    public TagriaSecurityXML getSecurity() {
	return security;
    }

    public void setSecurity(TagriaSecurityXML security) {
	this.security = security;
    }

}