
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Caption;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TableCaptionTag extends AbstractSimpleTagSupport {

	private String label;

	@Override
	public void render() {
		Caption caption = new Caption();
		if (!StringUtils.isEmpty(label)) {
			caption.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			caption.add(TagUtil.getBody(getJspBody()));
		}
		TagUtil.out(getJspContext(), caption);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
