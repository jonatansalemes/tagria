
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.H2;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class H2Tag extends SimpleTagSupport {
	
	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		H2 h2 = new H2();
		if (!StringUtils.isEmpty(label)) {
			h2.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			h2.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), h2);
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
