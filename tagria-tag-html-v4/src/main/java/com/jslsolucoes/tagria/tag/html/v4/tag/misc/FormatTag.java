
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.x.v4.tag.XTag;
public class FormatTag extends AbstractSimpleTagSupport {

	private String type;
	private String match;
	private String replace;

	@Override
	public Element render() {
		return cData();
	}
	
	private Element cData() {
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
