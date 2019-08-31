
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class InputTag extends AbstractSimpleTagSupport {

	private Boolean checked;
	private String name;
	private String value;
	private String pattern;
	private String type = "text";
	private String placeHolder;
	private String placeHolderKey;
	private String accept;
	private Boolean multiple = Boolean.FALSE;
	private Boolean required = Boolean.FALSE;
	private Boolean disabled = Boolean.FALSE;
	private Boolean focus = Boolean.FALSE;
	private String title;
	private String titleKey;
	private Integer maxLength;
	private Integer max;
	private Integer min;
	private Integer step;
	private String list;
	private Boolean autoComplete = Boolean.FALSE;

	@Override
	public Element render() {
		return input();

	}

	private Element input() {

		Element input = applyDynamicAttributesOn(ElementCreator.newInput()).attribute(Attribute.TYPE, type).attribute(Attribute.NAME, name)
				.attribute(Attribute.ARIA_LABEL,"input")
				.attribute(Attribute.ID, id(name, id)).attribute(Attribute.AUTOCOMPLETE, (autoComplete ? "on" : "off"));

		if (step != null) {
			input.attribute(Attribute.STEP, step);
		}

		if (max != null) {
			input.attribute(Attribute.MAX, max);
		}

		if (min != null) {
			input.attribute(Attribute.MIN, min);
		}

		if (!StringUtils.isEmpty(list)) {
			input.attribute(Attribute.LIST, list);
		}

		if (multiple) {
			input.attribute(Attribute.MULTIPLE, "multiple");
		}
		if (!StringUtils.isEmpty(accept)) {
			input.attribute(Attribute.ACCEPT, accept);
		}

		if (!"checkbox".equals(type) && !"radio".equals(type)) {
			input.attribute(Attribute.CLASS, "form-control shadow-sm");
		}

		if (focus) {
			input.attribute(Attribute.AUTOFOCUS, "autofocus");
		}

		if (hasKeyOrLabel(titleKey, title)) {
			input.attribute(Attribute.TITLE, keyOrLabel(titleKey, title));
		}

		if (maxLength != null) {
			input.attribute(Attribute.MAXLENGTH, maxLength);
		}

		if (hasKeyOrLabel(placeHolderKey, placeHolder)) {
			input.attribute(Attribute.PLACEHOLDER, keyOrLabel(placeHolderKey, placeHolder));
		}

		if (!StringUtils.isEmpty(value)) {
			input.attribute(Attribute.VALUE, value);
		}
		if (!StringUtils.isEmpty(pattern)) {
			input.attribute(Attribute.PATTERN, pattern);
		}
		if (("checkbox".equals(type) || "radio".equals(type)) && checked != null && checked) {
			input.attribute(Attribute.CHECKED, "checked");
		}
		if (disabled) {
			input.attribute(Attribute.DISABLED, "disabled");
			input.attribute(Attribute.CLASS, "disabled");
		}

		if (required) {
			input.attribute(Attribute.REQUIRED, "required");
			input.attribute(Attribute.CLASS, "form-required");
		}

		if (!StringUtils.isEmpty(cssClass)) {
			input.attribute(Attribute.CLASS, cssClass);
		}

		return input;
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

	

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	

	public Boolean getAutoComplete() {
	    return autoComplete;
	}

	public void setAutoComplete(Boolean autoComplete) {
	    this.autoComplete = autoComplete;
	}

	public String getPlaceHolder() {
	    return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
	    this.placeHolder = placeHolder;
	}

	public String getPlaceHolderKey() {
	    return placeHolderKey;
	}

	public void setPlaceHolderKey(String placeHolderKey) {
	    this.placeHolderKey = placeHolderKey;
	}

}
