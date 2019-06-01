
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Hr;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class HrTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		TagUtil.out(getJspContext(), new Hr());
	}
}
