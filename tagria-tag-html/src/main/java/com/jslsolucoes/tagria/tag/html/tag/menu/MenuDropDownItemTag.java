
package com.jslsolucoes.tagria.tag.html.tag.menu;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class MenuDropDownItemTag extends AbstractSimpleTagSupport {

	private String url = "#";
	private String label;
	private String labelKey;
	private String target = "_self";
	private String icon;

	@Override
	public Element render() {
		return a();
	}

	private Element a() {
		Element a = ElementCreator.newA().attribute(Attribute.ID, idForId(id))
				.attribute(Attribute.HREF, pathForUrl(url)).attribute(Attribute.TARGET, target)
				.attribute(Attribute.CLASS, "dropdown-item");

		if (!StringUtils.isEmpty(icon)) {
			a.add(span()).add(cdata());
		}

		if (hasKeyOrLabel(labelKey, label)) {
			a.add(keyOrLabel(labelKey, label));
		} else {
			a.add(bodyContent());
		}
		return a;
	}

	private Element span() {
		return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-" + icon);
	}

	private Element cdata() {
		return ElementCreator.newCData(" ");
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
