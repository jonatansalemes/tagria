
package com.jslsolucoes.tagria.tag.html.tag.form;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class FormTag extends AbstractSimpleTagSupport {

	private String method = "post";
	private String action = "#";
	private String name;
	private String validation;
	private Boolean multipart = Boolean.FALSE;
	private String target = "_self";

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newDiv()
				.attribute(Attribute.CLASS, "border border-secondary rounded p-2 shadow-sm").add(form());
	}

	private Element form() {
		String id = id();
		Element form = ElementCreator.newForm().attribute(Attribute.NOVALIDATE, "novalidate")
				.attribute(Attribute.TARGET, target).attribute(Attribute.ID,id).attribute(Attribute.METHOD, method)
				.attribute(Attribute.ACTION, pathForUrl(action)).add(divErrors()).add(bodyContent());
		if (!StringUtils.isEmpty(name)) {
			form.attribute(Attribute.NAME, name);
		}
		if (multipart) {
			form.attribute(Attribute.ENCTYPE, "multipart/form-data");
		}
		appendJsCode("$('#" + id + "').form({validation:'"
				+ (!StringUtils.isEmpty(validation) ? pathForUrl(validation) : "") + "',invalid:{email : '"
				+ keyForLibrary("form.email.invalid") + "',max:'" + keyForLibrary("form.max.invalid") + "',min:'"
				+ keyForLibrary("form.min.invalid") + "'}});");
		return form;
	}

	private Element divErrors() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "collapse form-error").add("&nbsp;");
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public Boolean getMultipart() {
		return multipart;
	}

	public void setMultipart(Boolean multipart) {
		this.multipart = multipart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
