
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Caption;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableCaptionTag extends SimpleTagSupport {

	private String label;

	@Override
	public void doTag() throws JspException, IOException {
		Caption caption = new Caption();
		if (!StringUtils.isEmpty(label)) {
			caption.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			caption.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), caption);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
