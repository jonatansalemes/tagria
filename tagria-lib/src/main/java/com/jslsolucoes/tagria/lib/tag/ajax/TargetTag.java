
package com.jslsolucoes.tagria.lib.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TargetTag extends SimpleTagSupport {
	private String data;
	private String type;
	private String target;
	private String value;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			TagUtil.out(getJspContext(), selector() + "." + type + "( " + valueForParameter() + ");");
		}
	}

	private String selector() {
		return "$('#" + TagUtil.getId(target, null) + "')";
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
