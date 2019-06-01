
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Img;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CarouselImageTag extends SimpleTagSupport {

	private String alt;
	private String url;
	private Boolean cdn = true;
	private Boolean rendered = Boolean.TRUE;
	private Integer height;
	private Integer width;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Img img = new Img();
			img.attribute(HtmlAttribute.CLASS, "d-block w-100");
			img.attribute(HtmlAttribute.SRC, TagUtil.getPathForStatic(getJspContext(), url, cdn));
			img.attribute(HtmlAttribute.ALT, TagUtil.getLocalized(alt, getJspContext()));
			if (width != null) {
				img.attribute(HtmlAttribute.WIDTH, width);
			}
			if (height != null) {
				img.attribute(HtmlAttribute.HEIGHT, height);
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
