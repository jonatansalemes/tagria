
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardTextTag extends SimpleTagSupport {


	@Override
	public void doTag() throws JspException, IOException {
		P p = new P();
		p.add(Attribute.CLASS, "card-text");
		p.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), p);
	}

}
