
package com.jslsolucoes.tagria.tag.html.v4.tag.layout;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

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
