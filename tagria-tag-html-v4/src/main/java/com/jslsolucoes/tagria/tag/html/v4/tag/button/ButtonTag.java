
package com.jslsolucoes.tagria.tag.html.v4.tag.button;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class ButtonTag extends AbstractSimpleTagSupport {

	private String type;
	private String url = "#";
	private String icon;
	private String title;
	private String titleKey;
	private Boolean dismiss = Boolean.FALSE;
	private String label;
	private String labelKey;
	private String target = "_self";
	private Boolean disabled = Boolean.FALSE;
	private Boolean autoblock = Boolean.FALSE;
	private String state = "primary";
	private Boolean filled = Boolean.FALSE;

	@Override
	public Element render() {
		return button();
	}

	private Element icon() {
		return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-" + icon);
	}

	private Element button() {
		Element button = ElementCreator.newA().attribute(Attribute.TARGET, target).attribute(Attribute.ID, idForId(id))
				.attribute(Attribute.CLASS, buttonCssClass()).attribute(Attribute.HREF, pathForUrl(url));

		if (!StringUtils.isEmpty(type)) {
			button.attribute(Attribute.DATA_TYPE, type);
		}

		if (!StringUtils.isEmpty(cssClass)) {
			button.attribute(Attribute.CLASS, cssClass);
		}

		if (disabled) {
			button.attribute(Attribute.CLASS, "disabled");
		}

		if (hasKeyOrLabel(titleKey, title)) {
			button.attribute(Attribute.TITLE, keyOrLabel(titleKey, title));
		}

		if (dismiss) {
			button.attribute(Attribute.DATA_DISMISS, "modal");
		}

		if (!StringUtils.isEmpty(icon)) {
			button.add(icon());
		}

		if (hasKeyOrLabel(labelKey, label)) {
			button.add(" ").add(keyOrLabel(labelKey, label));
		}

		if (autoblock) {
			appendJsCode(
					"$('#" + button.attribute(Attribute.ID) + "').click(function(){$(this).addClass('disabled');});");
		}

		return button;
	}

	private String buttonCssClass() {
		return "btn " + (filled ? "btn-" : "btn-outline-") + state + " shadow-sm";
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getDismiss() {
		return dismiss;
	}

	public void setDismiss(Boolean dismiss) {
		this.dismiss = dismiss;
	}

	public Boolean getAutoblock() {
		return autoblock;
	}

	public void setAutoblock(Boolean autoblock) {
		this.autoblock = autoblock;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public Boolean getFilled() {
		return filled;
	}

	public void setFilled(Boolean filled) {
		this.filled = filled;
	}

}
