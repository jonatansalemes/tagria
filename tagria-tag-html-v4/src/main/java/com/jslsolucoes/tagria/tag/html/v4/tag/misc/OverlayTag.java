
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class OverlayTag extends AbstractSimpleTagSupport {

    private Boolean enabled = Boolean.TRUE;

    @Override
    public Element render() {
	return overlay();
    }

    private Element overlay() {
	Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "overlay p-2");
	if (enabled) {
	    div.add(overlayLayer());
	}
	return div.add(bodyContent());
    }

    private Element overlayLayer() {
	return ElementCreator.newDiv()
		.attribute(Attribute.CLASS, "overlay-layer d-flex align-items-center justify-content-center")
		.add(overlayContent());
    }

    private Element overlayContent() {
	return ElementCreator.newDiv().add(lockerIcon());
    }

    private Element lockerIcon() {
	return ElementCreator.newSpan().attribute(Attribute.ID, idForId(id)).attribute(Attribute.CLASS,
		"fas fa-lock fa-fw");
    }

    public Boolean getEnabled() {
	return enabled;
    }

    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }

}
