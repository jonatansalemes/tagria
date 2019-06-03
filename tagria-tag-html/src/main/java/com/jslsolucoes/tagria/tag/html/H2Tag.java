
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.H2;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class H2Tag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		H2 h2 = new H2();
		h2.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h2);
	}

}
