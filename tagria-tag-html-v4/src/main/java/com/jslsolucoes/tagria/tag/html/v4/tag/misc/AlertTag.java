
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class AlertTag extends AbstractSimpleTagSupport {

	private Boolean dismissible = Boolean.FALSE;
	private Boolean visible = Boolean.TRUE;
	private String state;
	private String label;
	private String labelKey;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "alert alert-" + state + " shadow-xl")
				.attribute(Attribute.ROLE, "alert").attribute(Attribute.ID, idForId(id));
		if (!StringUtils.isEmpty(cssClass)) {
			div.attribute(Attribute.CLASS, cssClass);
		}
		if (!visible) {
			div.attribute(Attribute.CLASS, "collapse");
		}
		if (dismissible) {
			div.attribute(Attribute.CLASS, "alert-dismissible").add(close());
		}
		if (hasKeyOrLabel(labelKey, label)) {
			div.add(keyOrLabel(labelKey, label));
		} else {
			div.add(bodyContent());
		}
		return div;
	}

	private Element close() {
		return ElementCreator.newButton().attribute(Attribute.TYPE, "button").attribute(Attribute.CLASS, "close")
				.attribute(Attribute.DATA_DISMISS, "alert").add(closeSpan());
	}

	private Element closeSpan() {
		return ElementCreator.newScript().add("&times;");
	}

	public Boolean getDismissible() {
		return dismissible;
	}

	public void setDismissible(Boolean dismissible) {
		this.dismissible = dismissible;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
