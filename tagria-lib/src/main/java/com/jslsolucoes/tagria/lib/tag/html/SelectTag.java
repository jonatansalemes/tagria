
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.H4;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Input;
import com.jslsolucoes.tagria.html.Option;
import com.jslsolucoes.tagria.html.Select;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("rawtypes")
public class SelectTag extends SimpleTagSupport {

	private String id;
	private Collection data;
	private Map map;
	private String name;
	private String value;
	private String var;
	private Boolean required = Boolean.FALSE;
	private Boolean fixed = Boolean.FALSE;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {

		Div container = new Div();
		container.attribute(HtmlAttribute.ID, TagUtil.getId(this));

		Div row = new Div();
		row.attribute(HtmlAttribute.CLASS, "row");

		Div col1 = new Div();
		col1.attribute(HtmlAttribute.CLASS, "col col-11");

		Select select = new Select();
		select.attribute(HtmlAttribute.ID, TagUtil.getId(name, id, this));
		select.attribute(HtmlAttribute.NAME, name);
		select.add(new Option().attribute(HtmlAttribute.VALUE, "").add("- - -"));
		if (required) {
			select.attribute(HtmlAttribute.CLASS, "form-required");
			select.attribute(HtmlAttribute.REQUIRED, "required");
		}
		select.attribute(HtmlAttribute.CLASS, "select form-control shadow-sm");

		if (!StringUtils.isEmpty(cssClass)) {
			select.attribute(HtmlAttribute.CLASS, cssClass);
		}

		if (fixed) {
			select.add(TagUtil.getBody(getJspBody()));
		}
		if (!CollectionUtils.isEmpty(data)) {
			for (Object item : data) {
				getJspContext().setAttribute(var, item);
				select.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		} else if (map != null) {
			for (Object entry : map.entrySet()) {
				getJspContext().setAttribute(var, entry);
				select.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		}
		col1.add(select);
		row.add(col1);

		Div col2 = new Div();
		col2.attribute(HtmlAttribute.CLASS, "col col-1");

		Span span = new Span();
		span.attribute(HtmlAttribute.CLASS, "fas fa-search");
		A a = new A();
		a.attribute(HtmlAttribute.CLASS, "select-search-button btn btn-outline-primary shadow-sm");
		a.attribute(HtmlAttribute.HREF, "#");
		a.add(span);
		col2.add(a);
		row.add(col2);

		container.add(row);
		container.add(modal());

		TagUtil.out(getJspContext(), container);
		TagUtil.appendJs("$('#" + container.attribute(HtmlAttribute.ID) + "').select();", this);
	}

	public Div modal() {
		Div modal = new Div();
		modal.attribute(HtmlAttribute.CLASS, "modal fade");
		modal.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));

		Div dialog = new Div();
		dialog.attribute(HtmlAttribute.CLASS, "modal-dialog modal-dialog-centered");

		Div content = new Div();
		content.attribute(HtmlAttribute.CLASS, "modal-content");

		Div header = new Div();
		header.attribute(HtmlAttribute.CLASS, "modal-header");

		H4 h4 = new H4();
		h4.attribute(HtmlAttribute.CLASS, "modal-title");
		h4.add(TagUtil.getLocalizedForLib("select.search.title", getJspContext()));
		header.add(h4);

		Button close = new Button();
		close.attribute(HtmlAttribute.CLASS, "close");
		close.attribute(HtmlAttribute.DATA_DISMISS, "modal");
		close.add(new Span().add("&times;"));
		header.add(close);

		content.add(header);

		Div body = new Div();
		body.attribute(HtmlAttribute.CLASS, "modal-body");

		Div inputContainer = new Div();
		Input  input = new Input();
		input.attribute(HtmlAttribute.TYPE, "text");
		input.attribute(HtmlAttribute.AUTOCOMPLETE, "off");
		input.attribute(HtmlAttribute.CLASS, "form-control shadow-sm select-search-input");
		input.attribute(HtmlAttribute.PLACEHOLDER, TagUtil.getLocalizedForLib("select.search.input", getJspContext()));
		input.attribute(HtmlAttribute.AUTOFOCUS, "autofocus");
		inputContainer.add(input);
		body.add(inputContainer);

		Div searchContainer = new Div();
		searchContainer.attribute(HtmlAttribute.CLASS, "select-search-container");
		body.add(searchContainer);

		content.add(body);

		dialog.add(content);
		modal.add(dialog);
		return modal;
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
		this.data = data;
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

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Boolean getFixed() {
		return fixed;
	}

	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
