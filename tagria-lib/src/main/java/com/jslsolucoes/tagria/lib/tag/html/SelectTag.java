
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Option;
import com.jslsolucoes.tagria.lib.html.Select;
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

		Select select = new Select();
		select.add(Attribute.ID, TagUtil.getId(name, id));
		select.add(Attribute.NAME, name);
		select.add(new Option().add(Attribute.VALUE, "").add("- - -"));
		if (required) {
			select.add(Attribute.CLASS, "form-required");
			select.add(Attribute.REQUIRED, "required");
		}
		select.add(Attribute.CLASS, "form-control shadow-sm");

		if (!StringUtils.isEmpty(cssClass)) {
			select.add(Attribute.CLASS, cssClass);
		}
		
		if(fixed){
			select.add(TagUtil.getBody(getJspBody()));
		} if (!CollectionUtils.isEmpty(data)) {
			for (Object item : data) {
				getJspContext().setAttribute(var, item);
				select.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		} else if(map != null) {
			for (Object entry : map.entrySet()) {
				getJspContext().setAttribute(var, entry);
				select.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		}
		TagUtil.out(getJspContext(), select);
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
