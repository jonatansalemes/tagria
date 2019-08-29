package com.jslsolucoes.tagria.lib.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tagrialib")
@XmlAccessorType(XmlAccessType.FIELD)
public class TagriaXML {

	@XmlElementWrapper(name="templates")
    @XmlElement(name="template")
	private List<TagriaTemplateXML> templates;

	public List<TagriaTemplateXML> getTemplates() {
		return templates;
	}

	public void setTemplates(List<TagriaTemplateXML> templates) {
		this.templates = templates;
	}
}
