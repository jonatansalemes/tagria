
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class DropDownDividerTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		Div div = new Div();
		div.attribute(Attribute.CLASS, "dropdown-divider");
		TagUtil.out(getJspContext(), div);
	}

}
