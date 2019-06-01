
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Form;
import com.jslsolucoes.tagria.html.H2;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.tag.Toolballer;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FormTag extends SimpleTagSupport implements Toolballer {

	private String method = "post";
	private String action = "#";
	private String name;
	private String validation;
	private String label;
	private String toolbar;
	private Boolean rendered = Boolean.TRUE;
	private Boolean multipart = Boolean.FALSE;
	private String target = "_self";

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {

			Div container = new Div();
			container.attribute(HtmlAttribute.CLASS, "border border-secondary rounded p-2 shadow-sm");

			Form form = new Form();
			form.attribute(HtmlAttribute.NOVALIDATE, "novalidate");
			if (!StringUtils.isEmpty(name)) {
				form.attribute(HtmlAttribute.NAME, name);
			}
			form.attribute(HtmlAttribute.TARGET, target);
			form.attribute(HtmlAttribute.ID, TagUtil.getId(this));
			form.attribute(HtmlAttribute.METHOD, method);
			form.attribute(HtmlAttribute.ACTION, TagUtil.getPathForUrl(getJspContext(), action));
			if (multipart) {
				form.attribute(HtmlAttribute.ENCTYPE, "multipart/form-data");
			}

			if (!StringUtils.isEmpty(label)) {
				Div title = new Div();
				title.attribute(HtmlAttribute.CLASS, "text-center");
				H2 h2 = new H2();
				h2.attribute(HtmlAttribute.CLASS, "text-secondary");
				h2.add(TagUtil.getLocalized(getLabel(), getJspContext()));
				title.add(h2);
				form.add(title);
			}

			Div errors = new Div();
			errors.attribute(HtmlAttribute.CLASS, "collapse form-error");
			errors.add("&nbsp;");

			form.add(errors);
			form.add(TagUtil.getBody(getJspBody()));
			if (toolbar != null) {
				form.add(toolbar);
			}

			container.add(form);

			TagUtil.out(getJspContext(), container);

			TagUtil.appendJs("$('#" + form.attribute(HtmlAttribute.ID) + "').form({validation:'"
					+ (!StringUtils.isEmpty(validation) ? TagUtil.getPathForUrl(getJspContext(), validation) : "")
					+ "',invalid:{email : '" + TagUtil.getLocalizedForLib("form.email.invalid", getJspContext())
					+ "',max:'" + TagUtil.getLocalizedForLib("form.max.invalid", getJspContext()) + "',min:'"
					+ TagUtil.getLocalizedForLib("form.min.invalid", getJspContext()) + "'}});", this);
		}
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public void setToolbar(String html) {
		this.toolbar = html;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
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
