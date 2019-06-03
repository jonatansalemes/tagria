
package com.jslsolucoes.tagria.tag.html;

import java.util.Collection;

import javax.servlet.jsp.JspContext;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

@SuppressWarnings({ "rawtypes" })
public class DataBlockTag extends AbstractSimpleTagSupport {

	private String var;
	private Collection data;
	private Integer extraSmall;
	private Integer small;
	private Integer medium;
	private Integer large;

	@Override
	public void render() {
		JspContext jspContext = getJspContext();
		Div row = new Div();
		row.attribute(Attribute.CLASS, "row");
		for (Object object : data) {
			jspContext.setAttribute(var, object);
			Div col = new Div();
			col.attribute(Attribute.CLASS, "mt-3");
			col.attribute(Attribute.CLASS, "col-xs-" + extraSmall);

			if (small != null) {
				col.attribute(Attribute.CLASS, "col-sm-" + small);
			}
			if (medium != null) {
				col.attribute(Attribute.CLASS, "col-md-" + medium);
			}
			if (large != null) {
				col.attribute(Attribute.CLASS, "col-lg-" + large);
			}
			col.add(TagUtil.getBody(getJspBody()));
			row.add(col);
		}
		jspContext.setAttribute(var, null);

		TagUtil.out(getJspContext(), row);
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
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
