
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class ColTag extends AbstractSimpleTagSupport {

	private Integer extraSmall;
	private Integer small;
	private Integer medium;
	private Integer large;
	private String cssClass;

	@Override
	public void render() {
		Div div = new Div();
		div.attribute(Attribute.CLASS, "col");
		if (extraSmall != null) {
			div.attribute(Attribute.CLASS, "col-" + extraSmall);
		}
		if (small != null) {
			div.attribute(Attribute.CLASS, "col-sm-" + small);
		}
		if (medium != null) {
			div.attribute(Attribute.CLASS, "col-md-" + medium);
		}
		if (large != null) {
			div.attribute(Attribute.CLASS, "col-lg-" + large);
		}

		if (!StringUtils.isEmpty(cssClass)) {
			div.attribute(Attribute.CLASS, cssClass);
		}

		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);

	}

	public Integer getExtraSmall() {
		return extraSmall;
	}

	public void setExtraSmall(Integer extraSmall) {
		this.extraSmall = extraSmall;
	}

	public Integer getSmall() {
		return small;
	}

	public void setSmall(Integer small) {
		this.small = small;
	}

	public Integer getMedium() {
		return medium;
	}

	public void setMedium(Integer medium) {
		this.medium = medium;
	}

	public Integer getLarge() {
		return large;
	}

	public void setLarge(Integer large) {
		this.large = large;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
