
package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.CloneableJsAppender;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.v4.VarStatus;

public class FormGroupMultipleTag extends AbstractSimpleTagSupport implements CloneableJsAppender {

    private Collection<Object> data;
    private String var;
    private String label;
    private String labelKey;
    private Integer atLeast = 0;
    private Boolean empty = Boolean.FALSE;
    private String onAfterInsert;
    private String onAfterRemove;
    private String varStatus;
    private VarStatus varStatusObject = new VarStatus();
    private List<String> jsScripts = new ArrayList<>();

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	String id = id();
	Element div = ElementCreator.newDiv().attribute(Attribute.ID, id)
		.attribute(Attribute.CLASS, "form-group p-2 shadow-xl rounded bg-white fg-container").add(divToolbar())
		.add(divContent()).add(textAreaHtml()).add(textAreaScript());
	appendJsCode("$('#" + id + "').formGroup({atLeast:" + atLeast + ",empty:" + empty
		+ ",afterInsert:function(idx,element){" + (!StringUtils.isEmpty(onAfterInsert) ? onAfterInsert : "")
		+ " },afterRemove:function(){" + (!StringUtils.isEmpty(onAfterRemove) ? onAfterRemove : "") + "}});");
	return div;
    }

    private Element divContent() {
	Element content = ElementCreator.newDiv().attribute(Attribute.CLASS, "fg-content");
	if (!CollectionUtils.isEmpty(data)) {
	    for (Object object : data) {
		setAttribute(var, object);
		if (!StringUtils.isEmpty(varStatus)) {
		    setAttribute(varStatus, varStatusObject);
		}
		content.add(divFormGroup(bodyContent()));
		varStatusObject.increment();
	    }
	    if (!StringUtils.isEmpty(varStatus)) {
		setAttribute(varStatus, null);
	    }
	    setAttribute(var, null);
	} else {
	    for (int i = 0; i < (atLeast > 0 ? atLeast : 1); i++) {
		content.add(divFormGroup(bodyContent()));
	    }
	}
	return content;
    }

    private Element divToolbar() {
	Element toolbar = ElementCreator.newDiv().attribute(Attribute.CLASS, "p-2 d-flex align-items-center").add(divButtonGroupToolbar());
	if (hasKeyOrLabel(labelKey, label)) {
	    toolbar.add(divTitle());
	}
	return toolbar;
    }

    private Element divTitle() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "text-center flex-grow-1").add(h4());
    }

    private Element h4() {
	return ElementCreator.newH4().attribute(Attribute.CLASS, "text-secondary").add(keyOrLabel(labelKey, label));
    }

    private Element divButtonGroupToolbar() {
	return ElementCreator.newDiv().add(buttonPlus());
    }

    private Element buttonPlus() {
	return ElementCreator.newButton().attribute(Attribute.TYPE, "button")
		.attribute(Attribute.ARIA_LABEL, keyForLibrary("form.group.plus"))
		.attribute(Attribute.CLASS, "btn btn-outline-primary fg-plus shadow-xl").add(spanPlus());
    }

    private Element spanPlus() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-plus");
    }

    private Element textAreaHtml() {
	return ElementCreator.newTextArea().attribute(Attribute.CLASS, "d-none fg-template");
    }

    private Element textAreaScript() {
	return ElementCreator.newTextArea().attribute(Attribute.CLASS, "d-none fg-template-script")
		.add(scriptTemplate());
    }

    private Element scriptTemplate() {
	return ElementCreator.newScript().add(jsScripts.stream().collect(Collectors.joining()));
    }

    private Element divFormGroup(String bodyContent) {
	return divRow(bodyContent);
    }

    private Element divCol1(String bodyContent) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "col col-11")
		.add(ElementCreator.newDiv().add(bodyContent));
    }

    private Element divCol2() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "col col-1 my-auto text-center").add(buttonRemove());
    }

    private Element divRow(String bodyContent) {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "row fg-row shadow-xl rounded mt-3 mb-3 p-3")
		.add(divCol1(bodyContent)).add(divCol2());
    }

    private Element buttonRemove() {
	return ElementCreator.newButton().attribute(Attribute.ID, id())
		.attribute(Attribute.ARIA_LABEL, keyForLibrary("form.group.minus"))
		.attribute(Attribute.CLASS, "btn btn-outline-danger fg-minus shadow-xl").add(spanMinus());
    }

    private Element spanMinus() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-minus");
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public Collection<Object> getData() {
	return data;
    }

    public void setData(Collection<Object> data) {
	this.data = data;
    }

    public String getVar() {
	return var;
    }

    public void setVar(String var) {
	this.var = var;
    }

    public Integer getAtLeast() {
	return atLeast;
    }

    public void setAtLeast(Integer atLeast) {
	this.atLeast = atLeast;
    }

    public Boolean getEmpty() {
	return empty;
    }

    public void setEmpty(Boolean empty) {
	this.empty = empty;
    }

    public String getVarStatus() {
	return varStatus;
    }

    public void setVarStatus(String varStatus) {
	this.varStatus = varStatus;
    }

    public VarStatus getVarStatusObject() {
	return varStatusObject;
    }

    public void setVarStatusObject(VarStatus varStatusObject) {
	this.varStatusObject = varStatusObject;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

    @Override
    public void appendJavascriptCode(String jsCode) {
	this.jsScripts.add(jsCode);
    }

    @Override
    public Integer index() {
	return varStatusObject.getIndex();
    }

    public String getOnAfterInsert() {
	return onAfterInsert;
    }

    public void setOnAfterInsert(String onAfterInsert) {
	this.onAfterInsert = onAfterInsert;
    }

    public String getOnAfterRemove() {
	return onAfterRemove;
    }

    public void setOnAfterRemove(String onAfterRemove) {
	this.onAfterRemove = onAfterRemove;
    }

}
