
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableHeadTag extends AbstractSimpleTagSupport {

	private String label;

	@Override
	public void render() {
		Th th = new Th();
		if (!StringUtils.isEmpty(label)) {
			th.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			th.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), th);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
