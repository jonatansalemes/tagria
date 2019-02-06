
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Img;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CarouselImageTag extends SimpleTagSupport {

	private String alt;
	private String url;
	private Boolean cdn = true;
	private Boolean rendered = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Img img = new Img();
			img.add(Attribute.CLASS, "d-block w-100");
			img.add(Attribute.SRC, TagUtil.getPathForStatic(getJspContext(), url, cdn));
			img.add(Attribute.ALT, TagUtil.getLocalized(alt, getJspContext()));
			TagUtil.out(getJspContext(), img);
		}
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
