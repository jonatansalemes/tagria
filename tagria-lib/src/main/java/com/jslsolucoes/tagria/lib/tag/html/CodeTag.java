
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Code;
import com.jslsolucoes.tagria.lib.html.Pre;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CodeTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Pre pre = new Pre();
		Code code = new Code();
		code.add(TagUtil.getBody(getJspBody()).replaceAll(">", "&gt;").replaceAll("<", "&lt;").replaceAll("\n", "</br>")
				.replaceAll("    ", "&nbsp;&nbsp;&nbsp;&nbsp;"));
		pre.add(code);
		TagUtil.out(getJspContext(), pre);
	}
}
