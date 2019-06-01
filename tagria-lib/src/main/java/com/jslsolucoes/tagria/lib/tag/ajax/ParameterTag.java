
package com.jslsolucoes.tagria.lib.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ParameterTag extends SimpleTagSupport {

	private String src;
	private String type;
	private String name;
	private String value;
	private Boolean required = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		ParametersTag parametersTag = (ParametersTag) findAncestorWithClass(this, ParametersTag.class);
		parametersTag.addParameter(name, required, valueForParameter());
	}

	private String valueForParameter() {
		if (!StringUtils.isEmpty(value)) {
			return "'" + value + "'";
		} else {
			return "$('#" + TagUtil.getId(src, null, this) + "')" + "." + type + "()";
		}
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
