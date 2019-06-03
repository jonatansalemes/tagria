
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Code;
import com.jslsolucoes.tagria.html.Pre;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CodeTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		Pre pre = new Pre();
		Code code = new Code();
		code.add(TagUtil.getBody(getJspBody()).replaceAll(">", "&gt;").replaceAll("<", "&lt;").replaceAll("\n", "</br>")
				.replaceAll("    ", "&nbsp;&nbsp;&nbsp;&nbsp;"));
		pre.add(code);
		TagUtil.out(getJspContext(), pre);
	}
}
