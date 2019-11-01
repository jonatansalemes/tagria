package com.jslsolucoes.tagria.tag.auth.v4.tag;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.auth.v4.Authorizer;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AuthRuleTag extends AbstractSimpleTagSupport {

    private String uri;
    private String httpMethod = "GET";

    @Override
    public Element render() {
	return ElementCreator.newCData(bodyContent());
    }

    @Override
    public Boolean rendered() {
	return super.rendered() && isAuthorized();
    }

    private boolean isAuthorized() {
	return authorizer().isAllowed(httpServletRequest(), httpServletResponse(), uri, httpMethod);
    }

    private Authorizer authorizer() {
	try {
	    return (Authorizer) Class.forName(xml().getAuth().getClazz()).newInstance();
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    public String getUri() {
	return uri;
    }

    public void setUri(String uri) {
	this.uri = uri;
    }

    public String getHttpMethod() {
	return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
	this.httpMethod = httpMethod;
    }

}
