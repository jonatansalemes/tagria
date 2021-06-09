package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FieldsetTag extends AbstractSimpleTagSupport {

    private Boolean disabled = Boolean.FALSE;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
    
    @Override
    public Element render() {
	return fieldset();
    }

    private Element fieldset() {
	Element  fieldset = ElementCreator.newFieldset().add(bodyContent());
	if (disabled) {
	    fieldset.attribute(Attribute.DISABLED, "disabled");
	    fieldset.attribute(Attribute.CLASS, "disabled");
	}
	return fieldset;
    }

}
