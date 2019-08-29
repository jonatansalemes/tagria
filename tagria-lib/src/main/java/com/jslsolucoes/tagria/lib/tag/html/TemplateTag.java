package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TemplateTag extends SimpleTagSupport {
	
	private String render;
	
	@Override
	public void doTag() throws JspException, IOException {
		TagUtil.out(getJspContext(), "<template render=\""+render+"\"/>");
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

}
