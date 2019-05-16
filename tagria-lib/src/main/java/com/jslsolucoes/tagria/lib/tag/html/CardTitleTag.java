
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.H5;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardTitleTag extends SimpleTagSupport {


	@Override
	public void doTag() throws JspException, IOException {
		H5 h5 = new H5();
		h5.add(Attribute.CLASS, "card-title");
		h5.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h5);
	}

}
