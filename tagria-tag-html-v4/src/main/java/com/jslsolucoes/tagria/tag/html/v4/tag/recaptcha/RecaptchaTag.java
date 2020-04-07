package com.jslsolucoes.tagria.tag.html.v4.tag.recaptcha;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class RecaptchaTag extends AbstractSimpleTagSupport {

    private String siteKey;
    private String dataCallback;
    private String expiredCallback;

    @Override
    public Element render() {
	return div();
    }

    private Element div() {
	Element div  = ElementCreator.newDiv().attribute(Attribute.CLASS, "g-recaptcha").attribute(Attribute.DATA_SITEKEY,
		siteKey);
	
	if(!StringUtils.isEmpty(dataCallback)) {
	    div.attribute(Attribute.DATA_CALLBACK,
			dataCallback);
	}
	
	if(!StringUtils.isEmpty(expiredCallback)) {
	    div.attribute(Attribute.DATA_EXPIRED_CALLBACK,
				expiredCallback);
	}
	return div;
    }

    public String getSiteKey() {
	return siteKey;
    }

    public void setSiteKey(String siteKey) {
	this.siteKey = siteKey;
    }

    public String getDataCallback() {
	return dataCallback;
    }

    public void setDataCallback(String dataCallback) {
	this.dataCallback = dataCallback;
    }

    public String getExpiredCallback() {
	return expiredCallback;
    }

    public void setExpiredCallback(String expiredCallback) {
	this.expiredCallback = expiredCallback;
    }
}
