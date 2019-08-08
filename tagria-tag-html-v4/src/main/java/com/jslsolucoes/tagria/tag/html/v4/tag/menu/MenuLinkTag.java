package com.jslsolucoes.tagria.tag.html.v4.tag.menu;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class MenuLinkTag extends AbstractSimpleTagSupport {

	private String url = "#";
	private String label;
	private String labelKey;
	private String target = "_self";
	private String icon;

	@Override
	public Element render() {
		return li();
	}

	private Element span() {
		return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-" + icon);
	}

	private Element a() {
		Element a = ElementCreator.newA().attribute(Attribute.HREF, pathForUrl(url)).attribute(Attribute.TARGET, target)
				.attribute(Attribute.ID, idForId(id)).attribute(Attribute.CLASS, "nav-link");
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

	private Element cdata() {
		return ElementCreator.newCData(" ");
	}

	private Element li() {
		return ElementCreator.newLi().attribute(Attribute.CLASS, "nav-item").add(a());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}
}