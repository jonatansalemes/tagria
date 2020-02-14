
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class ImportTag extends AbstractSimpleTagSupport {

    private String type;
    private String url;

    @Override
    public void renderOnVoid() {
	if ("css".equals(type)) {
	    appendCssScript(url);
	} else if ("js".equals(type)) {
	    appendJsScript(url);
	} else {
	    throw new TagriaRuntimeException("Type " + type + " is not supported. Options: js,css");
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
