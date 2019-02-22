
package com.jslsolucoes.tagria.lib.tag.auth;

import java.io.IOException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.auth.Auth;
import com.jslsolucoes.tagria.lib.servlet.Tagria;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CheckTag extends SimpleTagSupport {

	private String uri;
	private String method;

	@Override
	public void doTag() throws JspException, IOException {
		Auth auth = Tagria.AUTH;
		if(!StringUtils.isEmpty(uri) && !StringUtils.isEmpty(method)) {
			if(auth.allowed(uri, method)) {
				TagUtil.out(getJspContext(), TagUtil.getBody(getJspBody()));
			}
		}
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
