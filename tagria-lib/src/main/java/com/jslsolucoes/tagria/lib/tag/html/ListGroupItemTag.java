
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ListGroupItemTag extends SimpleTagSupport {

	private Boolean rendered = Boolean.TRUE;
	private String cssClass;
	private String state;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Li li = new Li();
			li.add(Attribute.CLASS, "list-group-item");
			if (!StringUtils.isEmpty(cssClass)) {
				li.add(Attribute.CLASS, cssClass);
			}
			if (!StringUtils.isEmpty(state)) {
				li.add(Attribute.CLASS, "list-group-item-" + state);
			}
			li.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), li);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
