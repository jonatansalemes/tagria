
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings({ "rawtypes" })
public class DataBlockTag extends SimpleTagSupport {

	private String var;
	private Collection data;
	private Integer extraSmall;
	private Integer small;
	private Integer medium;
	private Integer large;

	@Override
	public void doTag() throws JspException, IOException {
		JspContext jspContext = getJspContext();
		Div row = new Div();
		row.attribute(HtmlAttribute.CLASS, "row");
		for (Object object : data) {
			jspContext.setAttribute(var, object);
			Div col = new Div();
			col.attribute(HtmlAttribute.CLASS, "mt-3");
			col.attribute(HtmlAttribute.CLASS, "col-xs-" + extraSmall);

			if (small != null) {
				col.attribute(HtmlAttribute.CLASS, "col-sm-" + small);
			}
			if (medium != null) {
				col.attribute(HtmlAttribute.CLASS, "col-md-" + medium);
			}
			if (large != null) {
				col.attribute(HtmlAttribute.CLASS, "col-lg-" + large);
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
