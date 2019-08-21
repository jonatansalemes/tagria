package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.H3;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H3Tag extends SimpleTagSupport {
	
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		H3 h3 = new H3();
		if (!StringUtils.isEmpty(label)) {
			h3.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			h3.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), h3);
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}