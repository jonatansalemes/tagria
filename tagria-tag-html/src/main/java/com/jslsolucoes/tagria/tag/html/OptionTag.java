
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Option;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class OptionTag extends AbstractSimpleTagSupport {

	private String value;

	@Override
	public void render() {
		Option option = new Option();
		option.attribute(Attribute.VALUE, value);
		option.add(TagUtil.getBody(getJspBody()));
		checkForSelected(option);
		TagUtil.out(getJspContext(), option);
	}

	private void checkForSelected(Option option) {
		SelectTag select = TagUtil.findAncestorWithClass(this, SelectTag.class);
		if (select != null) {
			if (value.equals(select.getValue()) || (select.getRequired() && !CollectionUtils.isEmpty(select.getData())
					&& select.getData().size() == 1)) {
				option.attribute(Attribute.SELECTED, "selected");
			}
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
