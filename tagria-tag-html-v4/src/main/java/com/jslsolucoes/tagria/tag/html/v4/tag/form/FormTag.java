
package com.jslsolucoes.tagria.tag.html.v4.tag.form;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class FormTag extends AbstractSimpleTagSupport {

	private String method = "post";
	private String action = "#";
	private String name;
	private String validation;
	private Boolean multipart = Boolean.FALSE;
	private String target = "_self";
	private String label;
	private String labelKey;
	private Boolean inline = Boolean.FALSE;
	private String onBeforeSubmit;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "p-2 shadow-xl rounded bg-white").add(form());
		if (!StringUtils.isEmpty(cssClass)) {
			div.attribute(Attribute.CLASS,cssClass);
		}
		return div;
	}

	private Element divBody() {
		return ElementCreator.newDiv().add(bodyContent());
	}

	private Element divHeader() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "text-center").add(h2());
	}

	private Element h2() {
		return ElementCreator.newH2().attribute(Attribute.CLASS, "text-secondary").add(keyOrLabel(labelKey, label));
	}

	private Element form() {
		String id = idForId(this.id);
		Element form = ElementCreator.newForm().attribute(Attribute.NOVALIDATE, "novalidate")
				.attribute(Attribute.TARGET, target).attribute(Attribute.ID, id).attribute(Attribute.METHOD, method)
				.attribute(Attribute.ACTION, pathForUrl(action)).add(divErrors());
		
		

		if (hasKeyOrLabel(labelKey, label)) {
			form.add(divHeader());
		}
		
		if(inline) {
		    form.attribute(Attribute.CLASS, "form-inline");
		}
		
		if (!StringUtils.isEmpty(cssClass)) {
		    form.attribute(Attribute.CLASS, cssClass);
		}

		form.add(divBody());
		if (!StringUtils.isEmpty(name)) {
			form.attribute(Attribute.NAME, name);
		}
		if (multipart) {
			form.attribute(Attribute.ENCTYPE, "multipart/form-data");
		}
		appendJsCode(
				"$('#" + id + "').form({validation:'" + (!StringUtils.isEmpty(validation) ? pathForUrl(validation) : "")
						+ "',invalid:{email : '" + keyForLibrary("form.email.invalid") + "',max:'"
						+ keyForLibrary("form.max.invalid") + "',min:'" + keyForLibrary("form.min.invalid") + "'}," 
													+ "beforeSubmit:function(){" + (StringUtils.isEmpty(onBeforeSubmit) ? "return true;" : onBeforeSubmit) + "}});");
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public Boolean getInline() {
		return inline;
	}

	public void setInline(Boolean inline) {
		this.inline = inline;
	}

	public String getOnBeforeSubmit() {
		return onBeforeSubmit;
	}

	public void setOnBeforeSubmit(String onBeforeSubmit) {
		this.onBeforeSubmit = onBeforeSubmit;
	}

	

}
