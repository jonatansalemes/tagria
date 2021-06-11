package com.jslsolucoes.tagria.tag.base.v4.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TagriaHttpServletRequest extends HttpServletRequestWrapper {
   
    public TagriaHttpServletRequest(HttpServletRequest httpServletRequest) {
	super(httpServletRequest);
    }

}
