
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Input;
import com.jslsolucoes.tagria.lib.tag.Formattabler;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class InputTag extends SimpleTagSupport implements Formattabler, DynamicAttributes {

	private Boolean checked;
	private String name;
	private String value;
	private String pattern;
	private String type = "text";
	private String placeholder;
	private String accept;
	private Boolean multiple = Boolean.FALSE;
	private Boolean required = Boolean.FALSE;
	private Boolean disabled = Boolean.FALSE;
	private Boolean focus = Boolean.FALSE;
	private String id;
	private String title;
	private Integer maxLength;
	private String cssClass;
	private Integer max;
	private Integer min;
	private Integer step;
	private String list;
	private Boolean autocomplete = Boolean.FALSE;
	private String formatType;
	private String formatMatch;
	private String formatReplace;
	private Map<String, String> attributes = new WeakHashMap<String, String>();

	@Override
	public void doTag() throws JspException, IOException {

		TagUtil.flushBody(getJspBody());

		Input input = new Input();
		input.attribute(HtmlAttribute.TYPE, type);
		input.attribute(HtmlAttribute.NAME, name);
		input.attribute(HtmlAttribute.AUTOCOMPLETE, (autocomplete ? "on" : "off"));

		attributes.entrySet().forEach(entry -> {
			input.attribute(entry.getKey(), entry.getValue());
		});

		if (step != null) {
			input.attribute(HtmlAttribute.STEP, step);
		}

		if (max != null) {
			input.attribute(HtmlAttribute.MAX, max);
		}

		if (min != null) {
			input.attribute(HtmlAttribute.MIN, min);
		}

		if (!StringUtils.isEmpty(list)) {
			input.attribute(HtmlAttribute.LIST, list);
		}

		if (multiple) {
			input.attribute(HtmlAttribute.MULTIPLE, "multiple");
		}
		if (!StringUtils.isEmpty(accept)) {
			input.attribute(HtmlAttribute.ACCEPT, accept);
		}

		input.attribute(HtmlAttribute.ID, TagUtil.getId(name, id, this));
		if (!"checkbox".equals(type) && !"radio".equals(type)) {
			input.attribute(HtmlAttribute.CLASS, "form-control shadow-sm");
		}

		if (focus) {
			input.attribute(HtmlAttribute.AUTOFOCUS, "autofocus");
		}

		if (!StringUtils.isEmpty(title)) {
			input.attribute(HtmlAttribute.TITLE, TagUtil.getLocalized(title, getJspContext()));
		}

		if (maxLength != null) {
			input.attribute(HtmlAttribute.MAXLENGTH, maxLength);
		}
		if (!StringUtils.isEmpty(placeholder)) {
			input.attribute(HtmlAttribute.PLACEHOLDER, TagUtil.getLocalized(placeholder, getJspContext()));
		}

		if (!StringUtils.isEmpty(formatType)) {
			value = TagUtil.format(formatType, formatMatch, formatReplace, value, getJspContext());
		}

		if (!StringUtils.isEmpty(value)) {
			input.attribute(HtmlAttribute.VALUE, TagUtil.getLocalized(value, getJspContext()));
		}
		if (!StringUtils.isEmpty(pattern)) {
			input.attribute(HtmlAttribute.PATTERN, pattern);
		}
		if (("checkbox".equals(type) || "radio".equals(type)) && checked != null && checked) {
			input.attribute(HtmlAttribute.CHECKED, "checked");
		}
		if (disabled) {
			input.attribute(HtmlAttribute.DISABLED, "disabled");
			input.attribute(HtmlAttribute.CLASS, "disabled");
		}

		if (required) {
			input.attribute(HtmlAttribute.REQUIRED, "required");
			input.attribute(HtmlAttribute.CLASS, "form-required");
		}

		if (!StringUtils.isEmpty(cssClass)) {
			input.attribute(HtmlAttribute.CLASS, cssClass);
		}

		TagUtil.out(getJspContext(), input);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getFocus() {
		return focus;
	}

	public void setFocus(Boolean focus) {
		this.focus = focus;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public Boolean getAutocomplete() {
		return autocomplete;
	}

	public void setAutocomplete(Boolean autocomplete) {
		this.autocomplete = autocomplete;
	}

	@Override
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	@Override
	public void setFormatMatch(String formatMatch) {
		this.formatMatch = formatMatch;
	}

	@Override
	public void setFormatReplace(String formatReplace) {
		this.formatReplace = formatReplace;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if (!localName.startsWith("data-")) {
			throw new RuntimeException(
					"Dynamic attributes must start with data- . Eg.  data-id=\"1\",data-url=\"/start\" ... ");
		}
		attributes.put(localName, value.toString());
	}

}
