package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MenuCollapseTag extends AbstractSimpleTagSupport {

	private String attachTo;
	private String attachToSelector;
	private String id;

	@Override
	public void render() {
		Button button = new Button();
		button.attribute(Attribute.ID, TagUtil.getId(id, this));
		button.attribute(Attribute.TYPE, "button");
		button.attribute(Attribute.CLASS, "navbar-toggler");
		button.attribute(Attribute.DATA_TOGGLE, "collapse");
		button.attribute(Attribute.DATA_TARGET, TagUtil.attachTo(attachToSelector, attachTo, this));
		button.add(new Span().attribute(Attribute.CLASS, "navbar-toggler-icon"));
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
