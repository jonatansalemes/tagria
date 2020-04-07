
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class SwitchTag extends AbstractSimpleTagSupport {

    private String name;
    private String value;
    private String onText;
    private String onTextKey;
    private String offText;
    private String offTextKey;
    private Boolean checked;

    @Override
    public Element render() {
	return input();
    }

    private Element input() {
	Element input = ElementCreator.newInput().attribute(Attribute.NAME, name)
		.attribute(Attribute.TYPE,"checkbox")
		.attribute(Attribute.ID, idForName(name)).attribute(Attribute.DATA_TOGGLE, "switch")
		.attribute(Attribute.DATA_ON_TEXT, onText()).attribute(Attribute.DATA_OFF_TEXT, offText());
	if (!StringUtils.isEmpty(value)) {
	    input.attribute(Attribute.VALUE, value);
	}
	
	if (checked != null && checked) {
	    input.attribute(Attribute.CHECKED, "checked");
	}
	
	appendJsCode("$('#" + input.attribute(Attribute.ID) + "').bootstrapSwitch();");
	return input;
    }

    private String offText() {
	if (hasKeyOrLabel(onTextKey, onText)) {
	    return keyOrLabel(onTextKey, onText);
	}
	return keyForLibrary("switch.off");
    }

    private String onText() {
	if (hasKeyOrLabel(offTextKey, offText)) {
	    return keyOrLabel(offTextKey, offText);
	}
	return keyForLibrary("switch.on");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOnText() {
        return onText;
    }

    public void setOnText(String onText) {
        this.onText = onText;
    }

    public String getOnTextKey() {
        return onTextKey;
    }

    public void setOnTextKey(String onTextKey) {
        this.onTextKey = onTextKey;
    }

    public String getOffText() {
        return offText;
    }

    public void setOffText(String offText) {
        this.offText = offText;
    }

    public String getOffTextKey() {
        return offTextKey;
    }

    public void setOffTextKey(String offTextKey) {
        this.offTextKey = offTextKey;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

}
