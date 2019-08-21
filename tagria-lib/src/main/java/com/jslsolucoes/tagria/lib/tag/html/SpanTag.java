
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class SpanTag extends SimpleTagSupport {
	
	private String cssClass;
	private Boolean rendered = Boolean.TRUE;
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Span span = new Span();
			if (!StringUtils.isEmpty(cssClass)) {
				span.add(Attribute.CLASS, cssClass);
			}
			if (!StringUtils.isEmpty(label)) {
				span.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				span.add(TagUtil.getBody(getJspBody()));
			}
			TagUtil.out(getJspContext(), span);
		}
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
