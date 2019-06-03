
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Hr;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class HrTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		TagUtil.out(getJspContext(), new Hr());
	}
}
