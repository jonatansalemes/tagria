
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class AutoCompleteTag extends SimpleTagSupport {
	
	private String url;
	private Integer delay = 3000;
	private String name;
	private Integer minLength = 3;
	private String text;
	private String value;
	private Boolean required = Boolean.FALSE;
	
	@Override
	public void doTag() throws JspException, IOException {
		Div container = new Div();
		container.add(Attribute.ID, TagUtil.getId(this));
		
		Input input = new Input();
		input.add(Attribute.TYPE,"search");
		input.add(Attribute.CLASS,"form-control autocomplete-input");
		if (required) {
			input.add(Attribute.REQUIRED, "required");
			input.add(Attribute.CLASS, "form-required");
		}
		if (!StringUtils.isEmpty(text)) {
			input.add(Attribute.VALUE, TagUtil.getLocalized(text, getJspContext()));
		}
		container.add(input);
		
		Input inputHidden = new Input();
		inputHidden.add(Attribute.ID, TagUtil.getId(name, null, this));
		inputHidden.add(Attribute.NAME,name);
		if (!StringUtils.isEmpty(value)) {
			inputHidden.add(Attribute.VALUE, TagUtil.getLocalized(value, getJspContext()));
		}
		inputHidden.add(Attribute.TYPE,"hidden");
		inputHidden.add(Attribute.CLASS,"autocomplete-input-hidden");
		container.add(inputHidden);
		
		Div results = new Div();
		results.add(Attribute.CLASS,"border border-secondary d-none autocomplete-results");
		container.add(results);
		
		TagUtil.out(getJspContext(), container);
	
		Script script = new Script();
		script.add("$('#" + container.get(Attribute.ID) + "').autocomplete({ url : '"+TagUtil.getPathForUrl(getJspContext(), url)+"',delay : "+delay+",minLength:"+minLength+",text: '"+(!StringUtils.isEmpty(text) ? text : "")+"'  });");
		TagUtil.out(getJspContext(), script);
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public Integer getDelay() {
		return delay;
	}


	public void setDelay(Integer delay) {
		this.delay = delay;
	}


	public Integer getMinLength() {
		return minLength;
	}


	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public Boolean getRequired() {
		return required;
	}


	public void setRequired(Boolean required) {
		this.required = required;
	}


	

}
