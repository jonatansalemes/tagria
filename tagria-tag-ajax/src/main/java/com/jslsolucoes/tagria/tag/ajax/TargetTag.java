
package com.jslsolucoes.tagria.tag.ajax;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TargetTag extends AbstractSimpleTagSupport {
	private String data;
	private String type;
	private String target;
	private String value;

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(FunctionTag.class).addOnSuccess(jsCode());
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

}
