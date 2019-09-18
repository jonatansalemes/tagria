package com.jslsolucoes.tagria.config.v4.xml;

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
    private List<TagriaTemplateXML> templates;

    @XmlElementWrapper(name = "formatters")
    @XmlElement(name = "formatter")
    private List<TagriaFormatterXML> formatters;

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

}