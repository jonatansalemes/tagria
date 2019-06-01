package com.jslsolucoes.tagria.lib.tag.html;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class MaskTagOnKeyPress extends SimpleTagSupport {

	@Override
	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
		MaskTag maskTag = TagUtil.findAncestorWithClass(this, MaskTag.class);
		maskTag.setOnKeyPress(TagUtil.getBody(getJspBody()));
	}

}