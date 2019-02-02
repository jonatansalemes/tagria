
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Img;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CardImageTag extends SimpleTagSupport {

	private String alt;
	private Integer height;
	private String url;
	private Integer width;
	private Boolean cdn = true;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Img img = new Img();
			img.add(Attribute.CLASS, "card-img-top");
			img.add(Attribute.SRC, TagUtil.getPathForStatic(getJspContext(), url, cdn));
			img.add(Attribute.ALT, TagUtil.getLocalized(alt, getJspContext()));
			if (width != null) {
				img.add(Attribute.WIDTH, width);
			} 
			if (height != null) {
				img.add(Attribute.HEIGHT, height);
			}
			TagUtil.out(getJspContext(), img);
		}
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
