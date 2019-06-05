
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class TabTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private String url;
	private Boolean active = Boolean.FALSE;
	private Boolean reloadOnSelect = Boolean.TRUE;

	@Override
	public void render() {
		TabPanelTag tabPanelTag = findAncestorWithClass(TabPanelTag.class);
		String id = id();
		tabPanelTag.addLi(li(id));
		tabPanelTag.addDiv(div(id));
	}

	private Element div(String id) {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "tab-pane m-2").attribute(Attribute.ID, id);
		if (active) {
			div.attribute(Attribute.CLASS, "active");
		}
		if (StringUtils.isEmpty(url)) {
			div.add(bodyContent());
		} else {
			div.add(iframe());
		}
		return div;
	}

	private Element iframe() {
		Element iframe = ElementCreator.newIframe().attribute(Attribute.CLASS, "iframe").attribute(Attribute.ID, id())
				.attribute(Attribute.SRC, pathForBlank()).attribute(Attribute.DATA_URL, pathForUrl(url));
		if (active) {
			iframe.attribute(Attribute.CLASS, "active");
		}
		appendJsCode("$('#" + iframe.attribute(Attribute.ID) + "').iframe();");
		return iframe;
	}

	private Element link(String id) {
		Element a = ElementCreator.newA().attribute(Attribute.CLASS, "nav-link").attribute(Attribute.HREF, "#" + id)
				.attribute(Attribute.DATA_TOGGLE, "tab").add(keyOrLabel(labelKey, label));
		if (active) {
			a.attribute(Attribute.CLASS, "active");
		}
		return a;
	}

	private Element li(String id) {
		Element li = ElementCreator.newLi().add(link(id));
		if (reloadOnSelect) {
			li.attribute(Attribute.CLASS, "tab-reload-on-select nav-item");
		}
		return li;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getReloadOnSelect() {
		return reloadOnSelect;
	}

	public void setReloadOnSelect(Boolean reloadOnSelect) {
		this.reloadOnSelect = reloadOnSelect;
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
