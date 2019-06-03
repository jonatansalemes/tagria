
package com.jslsolucoes.tagria.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TargetTag extends AbstractSimpleTagSupport {
	private String data;
	private String type;
	private String target;
	private String value;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered()) {
			FunctionTag functionTag = findAncestorWithClass(FunctionTag.class);
			functionTag.addOnSuccess(jsCode());
		}
	}

	private String jsCode() {
		return selector() + "." + type + "( " + valueForParameter() + ");";
	}
	
	private String selector() {
		return "$('#" + idForName(target) + "')";
	}

	private String valueForParameter() {
		if (!StringUtils.isEmpty(value)) {
			return "'" + value + "'";
		} else {
			return "data." + data + "";
		}
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

}
