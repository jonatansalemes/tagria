package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CarouselItemTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private String description;
	private String descriptionKey;
	private Boolean active = Boolean.FALSE;

	@Override
	public void render() {
		Element carouselItem = carouselItem();
		if (active) {
			carouselItem.attribute(Attribute.CLASS, "active");
		}
		if (hasKeyOrLabel(labelKey, label)) {
			Element carouselCaption = carouselCaption();
			if (hasKeyOrLabel(descriptionKey, description)) {
				carouselCaption.add(descriptionLabel());
			}
			carouselItem.add(carouselCaption);
		}
		out(carouselItem);
	}

	private Element descriptionLabel() {
		return ElementCreator.newP().add(keyOrLabel(descriptionKey, description));
	}

	private Element carouselCaptionLabel() {
		return ElementCreator.newH5().add(keyOrLabel(labelKey, label));
	}

	private Element carouselCaption() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "carousel-caption d-none d-md-block")
				.add(carouselCaptionLabel());
	}

	private Element carouselItem() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "carousel-item").add(bodyContent());
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