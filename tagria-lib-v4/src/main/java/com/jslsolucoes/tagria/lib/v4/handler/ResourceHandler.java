package com.jslsolucoes.tagria.lib.v4.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ResourceHandler {

    public Boolean accepts(HttpServletRequest httpServletRequest);

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
