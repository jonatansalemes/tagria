package com.jslsolucoes.tagria.tag.base.v4.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TagriaHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public TagriaHttpServletRequestWrapper(HttpServletRequest httpServletRequest) {
	super(httpServletRequest);
    }

}
