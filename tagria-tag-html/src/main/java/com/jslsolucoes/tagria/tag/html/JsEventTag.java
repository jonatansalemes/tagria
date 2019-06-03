
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class JsEventTag extends AbstractSimpleTagSupport {

	private String attachTo;
	private String event;
	
	private String attachToSelector;

	@Override
	public void render() {
		
			TagUtil.appendJs("$('" + TagUtil.attachTo(attachToSelector, attachTo, this) + "')." + event + "(function(){"
					+ TagUtil.getBody(getJspBody()) + "});", this);
		}

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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

}
