
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.tag.Formattabler;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FormatTag extends SimpleTagSupport {

	private String type;
	private String match;
	private String replace;

	@Override
	public void doTag() throws JspException, IOException {
		String body = TagUtil.getBody(getJspBody());
		Formattabler formattabler = (Formattabler) findAncestorWithClass(this, Formattabler.class);
		if (formattabler != null && StringUtils.isEmpty(body)) {
			formattabler.setFormatType(type);
			formattabler.setFormatMatch(match);
			formattabler.setFormatReplace(replace);
		} else {
			TagUtil.out(getJspContext(), TagUtil.format(type, match, replace, body, getJspContext()));
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getReplace() {
		return replace;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}

}
