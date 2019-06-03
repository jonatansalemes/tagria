
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ToolbarTag extends AbstractSimpleTagSupport {

	

	@Override
	public void render() {
		
			Toolballer form = TagUtil.findAncestorWithClass(this, Toolballer.class);
			form.setToolbar(TagUtil.getBody(getJspBody()));
		}
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}
