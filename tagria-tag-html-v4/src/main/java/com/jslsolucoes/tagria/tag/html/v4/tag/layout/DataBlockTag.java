package com.jslsolucoes.tagria.tag.html.v4.tag.layout;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractIterableSimpleTagSupport;

public class DataBlockTag extends AbstractIterableSimpleTagSupport {

    private Integer extraSmall;
    private Integer small;
    private Integer medium;
    private Integer large;
    private Integer extraLarge;

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "row");
	iterateOver((object) -> div.add(col()));
	return div;
    }

    private Element col() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "col mt-1")
		.attribute(Attribute.CLASS, "col-" + extraSmall).add(bodyContent());
	if (small != null) {
	    div.attribute(Attribute.CLASS, "col-sm-" + small);
	}
	if (medium != null) {
	    div.attribute(Attribute.CLASS, "col-md-" + medium);
	}
	if (large != null) {
	    div.attribute(Attribute.CLASS, "col-lg-" + large);
	}
	if (extraLarge != null) {
	    div.attribute(Attribute.CLASS, "col-xl-" + extraLarge);
	}
	return div;
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

    public Integer getExtraLarge() {
	return extraLarge;
    }

    public void setExtraLarge(Integer extraLarge) {
	this.extraLarge = extraLarge;
    }

}
