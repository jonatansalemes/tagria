
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AlertTag extends SimpleTagSupport {

	private Boolean dismissible = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;
	private Boolean visible = Boolean.TRUE;
	private String state;
	private String label;
	private String id;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {

		if (rendered != null && rendered) {
			Div div = new Div();
			div.attribute(HtmlAttribute.CLASS, "alert alert-" + state + " shadow-sm");
			div.attribute(HtmlAttribute.ROLE, "alert");
			div.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));

			if (!StringUtils.isEmpty(cssClass)) {
				div.attribute(HtmlAttribute.CLASS, cssClass);
			}

			if (!visible) {
				div.attribute(HtmlAttribute.CLASS, "collapse");
			}

			if (dismissible) {
				div.attribute(HtmlAttribute.CLASS, "alert-dismissible");
				Button button = new Button();
				button.attribute(HtmlAttribute.TYPE, "button");
				button.attribute(HtmlAttribute.CLASS, "close");
				button.attribute(HtmlAttribute.DATA_DISMISS, "alert");

				Span span = new Span();
				span.add("&times;");

				button.add(span);
				div.add(button);
			}
			if (!StringUtils.isEmpty(label)) {
				div.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				div.add(TagUtil.getBody(getJspBody()));
			}
			TagUtil.out(getJspContext(), div);
		}
	}

	public Boolean getDismissible() {
		return dismissible;
	}

	public void setDismissible(Boolean dismissible) {
		this.dismissible = dismissible;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}
