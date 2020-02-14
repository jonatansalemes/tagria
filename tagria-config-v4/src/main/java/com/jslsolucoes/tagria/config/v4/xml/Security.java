package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auth")
@XmlAccessorType(XmlAccessType.FIELD)
public class Security {

    @XmlElement(name = "class")
    private String clazz = "com.jslsolucoes.tagria.tag.security.v4.DefaultAuthorizer";

    public String getClazz() {
	return clazz;
    }

    public void setClazz(String clazz) {
	this.clazz = clazz;
    }
}
