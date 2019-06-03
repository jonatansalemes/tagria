package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class MaskTagOnKeyPress extends AbstractSimpleTagSupport {

	@Override
	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
		MaskTag maskTag = TagUtil.findAncestorWithClass(this, MaskTag.class);
		maskTag.setOnKeyPress(TagUtil.getBody(getJspBody()));
	}

}