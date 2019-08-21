package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H4Tag extends SimpleTagSupport {
	
	private String cssClass;
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		H4 h4 = new H4();
		h4.add(TagUtil.getBody(getJspBody()));
		
		if (!StringUtils.isEmpty(cssClass)) {
			h4.add(Attribute.CLASS, cssClass);
		}
		
		if (!StringUtils.isEmpty(label)) {
			h4.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			h4.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), h4);
	}
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}