
package com.jslsolucoes.tagria.tag.html.tag.misc;

import com.jslsolucoes.tagria.exception.TagriaRuntimeException;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ImportTag extends AbstractSimpleTagSupport {

	private String type;
	private String url;

	@Override
	public Element render() {
		if ("css".equals(type)) {
			return link();
		} else if ("js".equals(type)) {
			return script();
		}
		throw new TagriaRuntimeException("Type " + type + " is not supported. Options: js,css");
	}

	private Element script() {
		return ElementCreator.newScript().attribute(Attribute.SRC, pathForStatic(url));
	}

	private Element link() {
		return ElementCreator.newLink().attribute(Attribute.REL, "stylesheet").attribute(Attribute.TYPE, "text/css")
				.attribute(Attribute.HREF, pathForStatic(url));
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
