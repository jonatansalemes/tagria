
package com.jslsolucoes.tagria.tag.html.v4.tag.js;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class JsEventTag extends AbstractSimpleTagSupport {

    private String attachTo;
    private String event;
    private String attachToSelector;

    @Override
    public void renderOnVoid() {
	appendJsCode(
		"$('" + attachTo(attachToSelector, attachTo) + "')." + event + "(function(){" + bodyContent() + "});");
    }

    public String getAttachTo() {
	return attachTo;
    }

    public void setAttachTo(String attachTo) {
	this.attachTo = attachTo;
    }

    public String getEvent() {
	return event;
    }

    public void setEvent(String event) {
	this.event = event;
    }

    public String getAttachToSelector() {
	return attachToSelector;
    }

    public void setAttachToSelector(String attachToSelector) {
	this.attachToSelector = attachToSelector;
    }

}
