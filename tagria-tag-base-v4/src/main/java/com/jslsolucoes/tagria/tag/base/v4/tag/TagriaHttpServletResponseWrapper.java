package com.jslsolucoes.tagria.tag.base.v4.tag;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class TagriaHttpServletResponseWrapper extends HttpServletResponseWrapper {

    public TagriaHttpServletResponseWrapper(HttpServletResponse httpServletResponse) {
	super(httpServletResponse);
    }

}
