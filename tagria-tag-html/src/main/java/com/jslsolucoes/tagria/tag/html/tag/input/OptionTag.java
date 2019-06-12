
package com.jslsolucoes.tagria.tag.html.tag.input;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class OptionTag extends AbstractSimpleTagSupport {

	private String value;

	@Override
	public Element render() {
		return option();
	}

	private Element option() {
		Element option = ElementCreator.newOption().attribute(Attribute.VALUE, value).add(bodyContent());
		if (isSelected()) {
			option.attribute(Attribute.SELECTED, "selected");
		}
		return option;
	}

	private Boolean isSelected() {
		SelectTag selectTag = findAncestorWithClass(SelectTag.class);
		String selectValue = selectTag.getValue();
		if(!StringUtils.isEmpty(selectValue)) {
			return value.equals(selectTag.getValue()) || (selectTag.getRequired()
					&& !CollectionUtils.isEmpty(selectTag.getData()) && selectTag.getData().size() == 1);
		}
		return false;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
