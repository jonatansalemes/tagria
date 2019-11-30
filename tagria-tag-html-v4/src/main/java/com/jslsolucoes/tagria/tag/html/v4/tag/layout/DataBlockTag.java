package com.jslsolucoes.tagria.tag.html.v4.tag.layout;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;


public class DataBlockTag extends AbstractSimpleTagSupport {

    private String var;
    private Collection<Object> data;
    private Integer extraSmall;
    private Integer small;
    private Integer medium;
    private Integer large;

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "row");
	if (!CollectionUtils.isEmpty(data)) {
	    checkForDataSetExceed(data);
	    for (Object object : data) {
		setAttribute(var, object);
		div.add(col());
	    }
	    setAttribute(var, null);
	}
	return div;
    }

    private Element col() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "col mt-3")
		.attribute(Attribute.CLASS, "col-xs-" + extraSmall).add(bodyContent());
	if (small != null) {
	    div.attribute(Attribute.CLASS, "col-sm-" + small);
	}
	if (medium != null) {
	    div.attribute(Attribute.CLASS, "col-md-" + medium);
	}
	if (large != null) {
	    div.attribute(Attribute.CLASS, "col-lg-" + large);
	}
	return div;
    }

    public String getVar() {
	return var;
    }

    public void setVar(String var) {
	this.var = var;
    }

    public Collection<Object> getData() {
	return data;
    }

    public void setData(Collection<Object> data) {
	this.data = data;
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
}
