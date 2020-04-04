
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class PopoverTag extends AbstractSimpleTagSupport {

    private String label;
    private String labelKey;
    private String attachTo;
    private String attachToSelector;
    private String placement = "top";

    @Override
    public Element render() {
	Element element = ElementCreator.newDiv().attribute(Attribute.CLASS,"collapse").attribute(Attribute.ID, id()).add(bodyContent());
	appendJsCode("$('" + attachTo(attachToSelector, attachTo) + "').popover({trigger: 'focus', content: $('#"
		+ element.attribute(Attribute.ID) + "').html(), html:true, placement: '" + placement + "',title: '"
		+ (hasKeyOrLabel(labelKey, label) ? keyOrLabel(labelKey, label) : "") + "'});");
	return element;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getAttachTo() {
        return attachTo;
    }

    public void setAttachTo(String attachTo) {
        this.attachTo = attachTo;
    }

    public String getAttachToSelector() {
        return attachToSelector;
    }

    public void setAttachToSelector(String attachToSelector) {
        this.attachToSelector = attachToSelector;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

}
