
package com.jslsolucoes.tagria.tag.html.tag.card;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class CardImageTag extends AbstractSimpleTagSupport {

	private String alt;
	private String altKey;
	private String url;
	private Boolean cdn = Boolean.TRUE;
	private Integer height;
	private Integer width;
	private Boolean responsive = Boolean.FALSE;

	@Override
	public Element render() {
		return img();
	}

	private Element img() {
		Element img = ElementCreator.newImg().attribute(Attribute.SRC, pathForStatic(url, cdn))
				.attribute(Attribute.WIDTH, width).attribute(Attribute.HEIGHT, height);
		if (hasKeyOrLabel(altKey, alt)) {
			img.attribute(Attribute.ALT, keyOrLabel(altKey, alt));
		}
		if(responsive) {
			img.attribute(Attribute.CLASS,"card-img-top");
		}
		return img;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public Boolean getCdn() {
		return cdn;
	}

	public void setCdn(Boolean cdn) {
		this.cdn = cdn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAltKey() {
		return altKey;
	}

	public void setAltKey(String altKey) {
		this.altKey = altKey;
	}

	public Boolean getResponsive() {
		return responsive;
	}

	public void setResponsive(Boolean responsive) {
		this.responsive = responsive;
	}

}
