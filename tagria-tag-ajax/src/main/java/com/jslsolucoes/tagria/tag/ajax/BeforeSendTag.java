package com.jslsolucoes.tagria.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.jslsolucoes.tagria.base.AbstractSimpleTagSupport;

public class BeforeSendTag extends AbstractSimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		FunctionTag functionTag = (FunctionTag) findAncestorWithClass(this, FunctionTag.class);
		functionTag.setBeforeSend(body());
	}

}
