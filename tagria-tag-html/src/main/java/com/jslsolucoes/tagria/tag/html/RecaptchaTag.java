package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class RecaptchaTag extends AbstractSimpleTagSupport {

	private String siteKey;

	@Override
	public void render() {

		Div div = new Div();
		div.attribute(Attribute.CLASS, "g-recaptcha");
		div.attribute(Attribute.DATA_SITEKEY, siteKey);
		TagUtil.out(getJspContext(), div);
	}

	public String getSiteKey() {
		return siteKey;
	}

	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}
}
