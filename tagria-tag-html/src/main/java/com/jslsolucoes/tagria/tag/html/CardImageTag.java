
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Img;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardImageTag extends AbstractSimpleTagSupport {

	private String alt;
	private String url;
	private Boolean cdn = true;
	
	private Integer height;
	private Integer width;

	@Override
	public void render() {
		
			Img img = new Img();
			img.attribute(Attribute.CLASS, "card-img-top");
			img.attribute(Attribute.SRC, TagUtil.getPathForStatic(getJspContext(), url, cdn));
			img.attribute(Attribute.ALT, TagUtil.getLocalized(alt, getJspContext()));
			if (width != null) {
				img.attribute(Attribute.WIDTH, width);
			}
			if (height != null) {
				img.attribute(Attribute.HEIGHT, height);
			}
			TagUtil.out(getJspContext(), img);
		}
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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
}
