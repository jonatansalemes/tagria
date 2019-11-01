
package com.jslsolucoes.tagria.tag.ajax.v4.tag;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class MapOptionsTag extends AbstractSimpleTagSupport {
    private String target;
    private String text;
    private String value;

    @Override
    public void renderOnVoid() {
	String id = idForName(target);
	String onSuccess = "var defaultOption = $(document.createElement('option')).attr('value','').text('- - -');$('#"
		+ id + "').html('').append(defaultOption);for(var i=0; i < data.length; i++) {var text = new Array();"
		+ Arrays.asList(text.split(",")).stream().map(text -> "text.push(data[i]." + text + ");").collect(
			Collectors.joining())
		+ "var option= $(document.createElement('option')).attr('value',data[i]." + value
		+ ").text(text.join(' - '));$('#" + id + "').append(option);}";
	findAncestorWithClass(FunctionTag.class).addOnSuccess(onSuccess);
    }

    public String getTarget() {
	return target;
    }

    public void setTarget(String target) {
	this.target = target;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
