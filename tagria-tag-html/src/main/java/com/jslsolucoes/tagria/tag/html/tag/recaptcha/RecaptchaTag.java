package com.jslsolucoes.tagria.tag.html.tag.recaptcha;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class RecaptchaTag extends AbstractSimpleTagSupport {

	private String siteKey;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "g-recaptcha").attribute(Attribute.DATA_SITEKEY,
				siteKey);
	}

	public String getSiteKey() {
		return siteKey;
	}

	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}
}
