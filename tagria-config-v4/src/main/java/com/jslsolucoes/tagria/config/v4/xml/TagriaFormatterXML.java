package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "formatter")
@XmlAccessorType(XmlAccessType.FIELD)
public class TagriaFormatterXML {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String clazz;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getClazz() {
	return clazz;
    }

    public void setClazz(String clazz) {
	this.clazz = clazz;
    }

}
