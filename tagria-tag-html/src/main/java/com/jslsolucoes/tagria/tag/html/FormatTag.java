
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class FormatTag extends AbstractSimpleTagSupport {

	private String type;
	private String match;
	private String replace;

	@Override
	public void render() {
		String body = TagUtil.getBody(getJspBody());
		Formattabler formattabler = TagUtil.findAncestorWithClass(this, Formattabler.class);
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
