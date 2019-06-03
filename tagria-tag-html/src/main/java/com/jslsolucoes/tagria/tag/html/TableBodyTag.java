
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.TBody;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableBodyTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		TBody tbody = new TBody();
		tbody.add(TagUtil.getBody(getJspBody()));
		TagUtil.out(getJspContext(), tbody);
	}

}
