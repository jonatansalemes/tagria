package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.H1;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class H1Tag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		H1 h1 = new H1();
		h1.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), h1);
	}

}