
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class AlertTag extends AbstractSimpleTagSupport {

	private Boolean dismissible = Boolean.FALSE;
	private Boolean visible = Boolean.TRUE;
	private String state;
	private String label;
	private String key;
	private String id;
	private String cssClass;

	@Override
	public void render() {
		Element alert = alert();
		if (!StringUtils.isEmpty(cssClass)) {
			alert.attribute(Attribute.CLASS, cssClass);
		}
		if (!visible) {
			alert.attribute(Attribute.CLASS, "collapse");
		}
		if (dismissible) {
			alert.attribute(Attribute.CLASS, "alert-dismissible");
			alert.add(close());
		}
		if (hasKeyOrLabel(key, label)) {
			alert.add(keyOrLabel(key, label));
		} else {
			alert.add(bodyContent());
		}
		out(alert);
	}

	private Element alert() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "alert alert-" + state + " shadow-sm")
				.attribute(Attribute.ROLE, "alert").attribute(Attribute.ID, idForId(id));
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

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
