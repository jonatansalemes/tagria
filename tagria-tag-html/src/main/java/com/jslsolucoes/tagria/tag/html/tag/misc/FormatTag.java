
package com.jslsolucoes.tagria.tag.html.tag.misc;

import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.x.tag.XTag;

public class FormatTag extends AbstractSimpleTagSupport {

	private String type;
	private String match;
	private String replace;

	@Override
	public Element render() {
		return ElementCreator.newCData(XTag.format(type, match, replace, bodyContent(), locale()));
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
