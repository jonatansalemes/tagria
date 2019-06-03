package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.H3;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class H3Tag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		H3 h3 = new H3();
		h3.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h3);
	}

}