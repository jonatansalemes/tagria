package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class RecaptchaTag extends SimpleTagSupport {

	private String siteKey;

	@Override
	public void doTag() throws JspException, IOException {

		Div div = new Div();
		div.attribute(HtmlAttribute.CLASS, "g-recaptcha");
		div.attribute(HtmlAttribute.DATA_SITEKEY, siteKey);
		TagUtil.out(getJspContext(), div);
	}

	public String getSiteKey() {
		return siteKey;
	}

	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}
}
