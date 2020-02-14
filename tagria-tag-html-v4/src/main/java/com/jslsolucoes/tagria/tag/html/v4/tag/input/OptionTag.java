
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

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
	if (!StringUtils.isEmpty(selectValue)) {
	    return value.equals(selectTag.getValue())
		    || (selectTag.getRequired() && !CollectionUtils.isEmpty(dataSet(selectTag.getData()))
			    && dataSet(selectTag.getData()).size() == 1);
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
