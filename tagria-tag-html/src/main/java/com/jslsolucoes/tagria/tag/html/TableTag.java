
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Table;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableTag extends AbstractSimpleTagSupport {

	private Boolean stripe = Boolean.FALSE;
	private Boolean dark = Boolean.FALSE;
	private Boolean hover = Boolean.FALSE;
	private Boolean small = Boolean.FALSE;
	private Boolean border = Boolean.FALSE;

	@Override
	public void render() {
		Table table = new Table();
		table.attribute(Attribute.CLASS, "table");

		if (stripe) {
			table.attribute(Attribute.CLASS, "table-striped");
		}

		if (dark) {
			table.attribute(Attribute.CLASS, "table-dark");
		}

		if (hover) {
			table.attribute(Attribute.CLASS, "table-hover");
		}

		if (small) {
			table.attribute(Attribute.CLASS, "table-sm");
		}

		if (border) {
			table.attribute(Attribute.CLASS, "table-bordered");
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
