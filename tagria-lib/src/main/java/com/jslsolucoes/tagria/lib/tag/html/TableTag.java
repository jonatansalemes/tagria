
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Table;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableTag extends SimpleTagSupport {

	private Boolean stripe = Boolean.FALSE;
	private Boolean dark = Boolean.FALSE;
	private Boolean hover = Boolean.FALSE;
	private Boolean small = Boolean.FALSE;
	private Boolean border = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {
		Table table = new Table();
		table.attribute(HtmlAttribute.CLASS, "table");

		if (stripe) {
			table.attribute(HtmlAttribute.CLASS, "table-striped");
		}

		if (dark) {
			table.attribute(HtmlAttribute.CLASS, "table-dark");
		}

		if (hover) {
			table.attribute(HtmlAttribute.CLASS, "table-hover");
		}

		if (small) {
			table.attribute(HtmlAttribute.CLASS, "table-sm");
		}

		if (border) {
			table.attribute(HtmlAttribute.CLASS, "table-bordered");
		}

		table.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), table);
	}

	public Boolean getStripe() {
		return stripe;
	}

	public void setStripe(Boolean stripe) {
		this.stripe = stripe;
	}

	public Boolean getDark() {
		return dark;
	}

	public void setDark(Boolean dark) {
		this.dark = dark;
	}

	public Boolean getHover() {
		return hover;
	}

	public void setHover(Boolean hover) {
		this.hover = hover;
	}

	public Boolean getSmall() {
		return small;
	}

	public void setSmall(Boolean small) {
		this.small = small;
	}

	public Boolean getBorder() {
		return border;
	}

	public void setBorder(Boolean border) {
		this.border = border;
	}

}
