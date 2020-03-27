
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractIterableSimpleTagSupport;


public class SelectTag extends AbstractIterableSimpleTagSupport {

    private String name;
    private String value;
    private Boolean required = Boolean.FALSE;
    private Boolean fixed = Boolean.FALSE;
    private Boolean searchable = Boolean.FALSE;
    private Boolean disabled = Boolean.FALSE;

    @Override
    public Element render() {
	if (searchable) {
	    return div();
	} else {
	    return select();
	}
    }

    private Element div() {
	Element div = ElementCreator.newDiv().attribute(Attribute.ID, id()).add(divRow()).add(divModal());
	appendJsCode("$('#" + div.attribute(Attribute.ID) + "').searchableSelect();");
	return div;
    }

    private Element divRow() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "row").add(divCol1()).add(divCol2());
    }

    private Element divCol2() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "col col-1").add(a());

    }

    private Element a() {
	return ElementCreator.newA().attribute(Attribute.CLASS, "select-search-button btn btn-outline-primary ")
		.attribute(Attribute.HREF, "#").attribute(Attribute.ARIA_LABEL, keyForLibrary("select.search.button"))
		.add(span());
    }

    private Element span() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-search");
    }

    private Element divCol1() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "col col-11").add(select());
    }

    private Element select() {
	Element select = ElementCreator.newSelect().attribute(Attribute.ID, id(name, id))
		.attribute(Attribute.ARIA_LABEL, "select").attribute(Attribute.NAME, name).add(option());
	if (required) {
	    select.attribute(Attribute.CLASS, "form-required").attribute(Attribute.REQUIRED, "required");
	}

	if (disabled) {
	    select.attribute(Attribute.DISABLED, "disabled").attribute(Attribute.CLASS, "disabled");
	}

	select.attribute(Attribute.CLASS, "select form-control ");

	if (!StringUtils.isEmpty(cssClass)) {
	    select.attribute(Attribute.CLASS, cssClass);
	}
	if (fixed) {
	    select.add(bodyContent());
	} else {
	    iterateOver(object-> select.add(bodyContent()));
	}
	appendJsCode("$('#" + select.attribute(Attribute.ID) + "').select();");

	return select;
    }

    private Element option() {
	return ElementCreator.newOption().attribute(Attribute.VALUE, "").add("- - -");
    }

    public Element divModal() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal fade").attribute(Attribute.ID, idForId(id))
		.add(divModalDialog());
    }

    private Element divModalBody() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-body").add(divInput()).add(divSearch());
    }

    private Element divSearch() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "select-search-container");
    }

    private Element divInput() {
	return ElementCreator.newDiv().add(input());
    }

    private Element input() {
	return ElementCreator.newInput().attribute(Attribute.TYPE, "text").attribute(Attribute.AUTOCOMPLETE, "off")
		.attribute(Attribute.CLASS, "form-control  select-search-input")
		.attribute(Attribute.PLACEHOLDER, keyForLibrary("select.search.input"))
		.attribute(Attribute.AUTOFOCUS, "autofocus");
    }

    private Element divModalHeader() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-header").add(h4()).add(button());
    }

    private Element button() {
	return ElementCreator.newA().attribute(Attribute.HREF, javascriptForVoid()).attribute(Attribute.CLASS, "close")
		.attribute(Attribute.DATA_DISMISS, "modal").add(spanTimes());
    }

    private Element spanTimes() {
	return ElementCreator.newSpan().add("&times;");
    }

    private Element h4() {
	return ElementCreator.newH4().attribute(Attribute.CLASS, "modal-title")
		.add(keyForLibrary("select.search.title"));
    }

    private Element divModalContent() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-content").add(divModalHeader())
		.add(divModalBody());
    }

    private Element divModalDialog() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-dialog").add(divModalContent());
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

    public Boolean getDisabled() {
	return disabled;
    }

    public void setDisabled(Boolean disabled) {
	this.disabled = disabled;
    }

    public Boolean getRequired() {
	return required;
    }

    public void setRequired(Boolean required) {
	this.required = required;
    }
  
    public Boolean getFixed() {
	return fixed;
    }

    public void setFixed(Boolean fixed) {
	this.fixed = fixed;
    }

    public Boolean getSearchable() {
	return searchable;
    }

    public void setSearchable(Boolean searchable) {
	this.searchable = searchable;
    }

}
