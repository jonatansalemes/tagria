
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.html.Option;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Select;
import com.jslsolucoes.tagria.lib.html.Span;
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
	private Boolean searchable = Boolean.FALSE;
	private String cssClass;

	@Override
	public void doTag() throws JspException, IOException {
		
		
		
		Select select = new Select();
		select.add(Attribute.ID, TagUtil.getId(name, id, this));
		select.add(Attribute.NAME, name);
		select.add(new Option().add(Attribute.VALUE, "").add("- - -"));
		if (required) {
			select.add(Attribute.CLASS, "form-required");
			select.add(Attribute.REQUIRED, "required");
		}
		select.add(Attribute.CLASS, "select form-control shadow-sm");

		if (!StringUtils.isEmpty(cssClass)) {
			select.add(Attribute.CLASS, cssClass);
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
		
		if(searchable) {
			Div container = new Div();
			container.add(Attribute.ID, TagUtil.getId(this));
	
			Div row = new Div();
			row.add(Attribute.CLASS, "row");
	
			Div col1 = new Div();
			col1.add(Attribute.CLASS, "col col-11");
	
			
			col1.add(select);
			row.add(col1);
	
			Div col2 = new Div();
			col2.add(Attribute.CLASS, "col col-1");
	
			Span span = new Span();
			span.add(Attribute.CLASS, "fas fa-search");
			A a = new A();
			a.add(Attribute.CLASS, "select-search-button btn btn-outline-primary shadow-sm");
			a.add(Attribute.HREF, "#");
			a.add(span);
			col2.add(a);
			row.add(col2);
	
			container.add(row);
			container.add(modal());
	
			TagUtil.out(getJspContext(), container);
	
			Script script = new Script();
			script.add("$('#" + container.get(Attribute.ID) + "').select();");
			TagUtil.out(getJspContext(), script);
		} else {
			TagUtil.out(getJspContext(), select);
		}

	}

	public Div modal() {
		Div modal = new Div();
		modal.add(Attribute.CLASS, "modal fade");
		modal.add(Attribute.ID, TagUtil.getId(id, this));

		Div dialog = new Div();
		dialog.add(Attribute.CLASS, "modal-dialog");

		Div content = new Div();
		content.add(Attribute.CLASS, "modal-content");

		Div header = new Div();
		header.add(Attribute.CLASS, "modal-header");

		H4 h4 = new H4();
		h4.add(Attribute.CLASS, "modal-title");
		h4.add(TagUtil.getLocalizedForLib("select.search.title", getJspContext()));
		header.add(h4);

		Button close = new Button();
		close.add(Attribute.CLASS, "close");
		close.add(Attribute.DATA_DISMISS, "modal");
		close.add(new Span().add("&times;"));
		header.add(close);

		content.add(header);

		Div body = new Div();
		body.add(Attribute.CLASS, "modal-body");
		
		
		Div inputContainer = new Div();
		Input input = new Input();
		input.add(Attribute.TYPE, "text");
		input.add(Attribute.AUTOCOMPLETE, "off");
		input.add(Attribute.CLASS, "form-control shadow-sm select-search-input");
		input.add(Attribute.PLACEHOLDER, TagUtil.getLocalizedForLib("select.search.input", getJspContext()));
		input.add(Attribute.AUTOFOCUS, "autofocus");
		inputContainer.add(input);
		body.add(inputContainer);
		
		Div searchContainer = new Div();
		searchContainer.add(Attribute.CLASS, "select-search-container");
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

	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

}
