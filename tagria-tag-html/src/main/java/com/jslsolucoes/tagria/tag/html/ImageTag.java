
package com.jslsolucoes.tagria.tag.html;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class ImageTag extends AbstractSimpleTagSupport {

	private String alt;
	private String altKey;
	private String shape;
	private Integer height;
	private String url;
	private Integer width;
	private String cssClass;
	private Boolean cdn = true;
	private Boolean responsive = true;

	@Override
	public Element render() {

		return img();
	}

	private Element img() {
		Element img = ElementCreator.newImg().attribute(Attribute.SRC, pathForStatic(url, cdn)).attribute(Attribute.ALT,
				keyOrLabel(altKey, alt));
		if (responsive) {
			img.attribute(Attribute.CLASS, "img-responsive");
		}
		if (!StringUtils.isEmpty(shape)) {
			img.attribute(Attribute.CLASS, "img-" + shape);
		}
		if (!StringUtils.isEmpty(cssClass)) {
			img.attribute(Attribute.CLASS, cssClass);
		}
		if (width != null) {
			img.attribute(Attribute.WIDTH, width);
		}
		if (height != null) {
			img.attribute(Attribute.HEIGHT, height);
		}
		return img;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
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

	public Boolean getCdn() {
		return cdn;
	}

	public void setCdn(Boolean cdn) {
		this.cdn = cdn;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Boolean getResponsive() {
		return responsive;
	}

	public void setResponsive(Boolean responsive) {
		this.responsive = responsive;
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
}
