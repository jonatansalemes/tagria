
package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class LinkTag extends AbstractSimpleTagSupport {

    private String url;
    private String label;
    private String labelKey;
    private String target = "_self";
    private Boolean disabled = Boolean.FALSE;

    @Override
    public Element render() {
	return a();
    }

    private Element a() {
	Element a = applyDynamicAttributesOn(ElementCreator.newA()).attribute(Attribute.ID, idForId(id))
		.attribute(Attribute.HREF, href()).attribute(Attribute.TARGET, target);
	if (hasKeyOrLabel(labelKey, label)) {
	    a.add(keyOrLabel(labelKey, label));
	} else {
	    a.add(bodyContent());
	}

	if (disabled) {
	    a.attribute(Attribute.DISABLED, "disabled");
	    a.attribute(Attribute.CLASS, "disabled");
	}

	if (!StringUtils.isEmpty(cssClass)) {
	    a.attribute(Attribute.CLASS, cssClass);
	}

	return a;
    }

    private String href() {
	return (disabled ? "#" : pathForUrl(url));
    }

    public Boolean getDisabled() {
	return disabled;
    }

    public void setDisabled(Boolean disabled) {
	this.disabled = disabled;
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
