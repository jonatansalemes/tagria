
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ColTag extends SimpleTagSupport {

	private Integer extraSmall;
	private Integer small;
	private Integer medium;
	private Integer large;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		Div div = new Div();
		if(extraSmall != null){
			div.add(Attribute.CLASS, "col-" + extraSmall);
		}
		if(small != null){
			div.add(Attribute.CLASS, "col-sm-" + small);
		}
		if(medium != null){
			div.add(Attribute.CLASS, "col-md-" + medium);
		}
		if(large != null){
			div.add(Attribute.CLASS, "col-lg-" + large);
		}
		
		if (!StringUtils.isEmpty(cssClass)) {
			div.add(Attribute.CLASS, cssClass);
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
