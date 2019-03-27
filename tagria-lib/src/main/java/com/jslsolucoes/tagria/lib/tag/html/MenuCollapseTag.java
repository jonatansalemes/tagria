package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MenuCollapseTag extends SimpleTagSupport {

	private String attachTo;
	private String attachToSelector;
	private String id;
	
	@Override
	public void doTag() throws JspException, IOException {
		Button button = new Button();
		button.add(Attribute.ID, TagUtil.getId(id));
		button.add(Attribute.TYPE,"button");
		button.add(Attribute.CLASS,"navbar-toggler");
		button.add(Attribute.DATA_TOGGLE,"collapse");
		button.add(Attribute.DATA_TARGET,TagUtil.attachTo(attachToSelector,attachTo,this));	
		button.add(new Span().add(Attribute.CLASS,"navbar-toggler-icon"));
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
