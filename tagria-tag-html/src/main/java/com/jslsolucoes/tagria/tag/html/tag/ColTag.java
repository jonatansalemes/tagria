
package com.jslsolucoes.tagria.tag.html.tag;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ColTag extends AbstractSimpleTagSupport {

	private Integer extraSmall;
	private Integer small;
	private Integer medium;
	private Integer large;
	private String cssClass;

	@Override
	public Element render() {
		return col();
	}

	private Element col() {
		Element col = ElementCreator.newDiv().attribute(Attribute.CLASS, "col").add(bodyContent());
		if (extraSmall != null) {
			col.attribute(Attribute.CLASS, "col-" + extraSmall);
		}
		if (small != null) {
			col.attribute(Attribute.CLASS, "col-sm-" + small);
		}
		if (medium != null) {
			col.attribute(Attribute.CLASS, "col-md-" + medium);
		}
		if (large != null) {
			col.attribute(Attribute.CLASS, "col-lg-" + large);
		}
		if (!StringUtils.isEmpty(cssClass)) {
			col.attribute(Attribute.CLASS, cssClass);
		}
		return col;
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
