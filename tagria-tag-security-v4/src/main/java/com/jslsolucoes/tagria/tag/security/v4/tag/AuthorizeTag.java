package com.jslsolucoes.tagria.tag.security.v4.tag;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AuthorizeTag extends AbstractSimpleTagSupport {

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
