
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class PTag extends AbstractSimpleTagSupport {

	

	@Override
	public void render() {
		
			P p = new P();
			p.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), p);
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

}
