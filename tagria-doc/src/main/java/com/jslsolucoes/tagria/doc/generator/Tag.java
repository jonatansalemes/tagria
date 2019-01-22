
package com.jslsolucoes.tagria.doc.generator;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("tag")
public class Tag {

	private String name;

	private String description;

	@XStreamAlias("display-name")
	private String group;

	private String example;

	@XStreamAlias("tag-class")
	private String tagClass;

	@XStreamAlias("body-content")
	private String bodyContent;

	@XStreamImplicit
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

}
