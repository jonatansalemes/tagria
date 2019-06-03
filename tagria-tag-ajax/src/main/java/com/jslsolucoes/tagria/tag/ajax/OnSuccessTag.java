
package com.jslsolucoes.tagria.tag.ajax;

import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class OnSuccessTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		flushBodyContent();
	}

}
