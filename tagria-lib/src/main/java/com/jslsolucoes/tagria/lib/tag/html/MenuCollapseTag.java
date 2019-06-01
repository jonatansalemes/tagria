package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuCollapseTag extends SimpleTagSupport {

	private String attachTo;
	private String attachToSelector;
	private String id;

	@Override
	public void doTag() throws JspException, IOException {
		Button button = new Button();
		button.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
		button.attribute(HtmlAttribute.TYPE, "button");
		button.attribute(HtmlAttribute.CLASS, "navbar-toggler");
		button.attribute(HtmlAttribute.DATA_TOGGLE, "collapse");
		button.attribute(HtmlAttribute.DATA_TARGET, TagUtil.attachTo(attachToSelector, attachTo, this));
		button.add(new Span().attribute(HtmlAttribute.CLASS, "navbar-toggler-icon"));
		TagUtil.out(getJspContext(), button);
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
