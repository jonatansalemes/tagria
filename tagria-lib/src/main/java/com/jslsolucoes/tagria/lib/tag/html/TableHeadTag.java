
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableHeadTag extends SimpleTagSupport {

	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		Th th = new Th();
		if (!StringUtils.isEmpty(label)) {
			th.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			th.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), th);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
