package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="template")
@XmlAccessorType(XmlAccessType.FIELD)
public class TagriaTemplateXML {
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "TagriaTemplateXML [name=" + name + ", path=" + path + "]";
	}
	
}