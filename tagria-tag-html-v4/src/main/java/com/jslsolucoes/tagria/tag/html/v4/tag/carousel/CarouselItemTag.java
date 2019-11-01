package com.jslsolucoes.tagria.tag.html.v4.tag.carousel;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class CarouselItemTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private String description;
	private String descriptionKey;
	private Boolean active = Boolean.FALSE;

	@Override
	public Element render() {
		return div();
	}

	private Element p() {
		return ElementCreator.newP().add(keyOrLabel(descriptionKey, description));
	}

	private Element h5() {
		return ElementCreator.newH5().add(keyOrLabel(labelKey, label));
	}

	private Element divCaption() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "carousel-caption d-none d-md-block")
				.add(h5());
		if (hasKeyOrLabel(descriptionKey, description)) {
			div.add(p());
		}
		return div;
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "carousel-item").add(bodyContent());
		if (active) {
			div.attribute(Attribute.CLASS, "active");
		}
		if (hasKeyOrLabel(labelKey, label)) {
			div.add(divCaption());
		}
		return div;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public String getDescriptionKey() {
		return descriptionKey;
	}

	public void setDescriptionKey(String descriptionKey) {
		this.descriptionKey = descriptionKey;
	}

}