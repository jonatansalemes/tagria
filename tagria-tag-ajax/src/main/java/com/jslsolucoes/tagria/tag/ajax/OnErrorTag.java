
package com.jslsolucoes.tagria.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class OnErrorTag extends AbstractSimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		FunctionTag functionTag = findAncestorWithClass(FunctionTag.class);
		functionTag.setOnError(bodyContent());
	}

}
