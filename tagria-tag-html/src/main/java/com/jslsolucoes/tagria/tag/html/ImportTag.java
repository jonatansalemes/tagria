
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Link;
import com.jslsolucoes.tagria.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class ImportTag extends AbstractSimpleTagSupport {

	private String type;
	private String url;

	@Override
	public void render() {

		if ("css".equals(type)) {
			Link link = new Link();
			link.attribute(Attribute.REL, "stylesheet");
			link.attribute(Attribute.TYPE, "text/css");
			link.attribute(Attribute.HREF, TagUtil.getPathForStatic(getJspContext(), url));
			TagUtil.out(getJspContext(), link);
		} else if ("js".equals(type)) {
			Script script = new Script();
			script.attribute(Attribute.SRC, TagUtil.getPathForStatic(getJspContext(), url));
			TagUtil.out(getJspContext(), script);
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
