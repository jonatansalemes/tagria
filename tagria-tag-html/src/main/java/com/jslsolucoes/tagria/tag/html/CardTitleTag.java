
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.H5;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CardTitleTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		H5 h5 = new H5();
		h5.attribute(Attribute.CLASS, "card-title");
		h5.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h5);
	}

}
