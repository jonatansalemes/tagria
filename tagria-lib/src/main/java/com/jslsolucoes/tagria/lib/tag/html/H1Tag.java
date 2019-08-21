package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.H1;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H1Tag extends SimpleTagSupport {
	
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		H1 h1 = new H1();
		if (!StringUtils.isEmpty(label)) {
			h1.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			h1.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), h1);
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}