
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardHeaderTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		Div div = new Div();
		div.attribute(Attribute.CLASS, "card-header");
		div.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), div);
	}

}
