
package com.jslsolucoes.tagria.doc.v4.generator;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

@XmlRootElement(name = "tag")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {

    private String name;

    private String description;

    @XmlElement(name = "dynamic-attributes")
    private Boolean dynamicAttributes;

    @XmlElement(name = "display-name")
    private String group;

    private String example;

    @XmlElement(name = "tag-class")
    private String tagClass;

    @XmlElement(name = "body-content")
    private String bodyContent;

    @XmlElementWrapper(name = "attributes")
    @XmlElement(name = "attribute")
    private List<Attribute> attributes;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getTagClass() {
	return tagClass;
    }

    public void setTagClass(String tagClass) {
	this.tagClass = tagClass;
    }

    public String getBodyContent() {
	return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
	this.bodyContent = bodyContent;
    }

    public List<Attribute> getAttributes() {
	return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
	this.attributes = attributes;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getExample() {
	return example;
    }

    public void setExample(String example) {
	this.example = example;
    }

    public String getExampleEscaped() {
	if (StringUtils.isEmpty(example))
	    return "";
	return example.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\$", "\\\\\\$");
    }

    public String getGroup() {
	return group;
    }

    public void setGroup(String group) {
	this.group = group;
    }

    public Boolean getDynamicAttributes() {
	return dynamicAttributes;
    }

    public void setDynamicAttributes(Boolean dynamicAttributes) {
	this.dynamicAttributes = dynamicAttributes;
    }

}
