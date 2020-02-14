
package com.jslsolucoes.tagria.lib.v4.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslsolucoes.tagria.lib.v4.handler.ResourceHandler;
import com.jslsolucoes.tagria.lib.v4.handler.impl.BlankResourceHandler;
import com.jslsolucoes.tagria.lib.v4.handler.impl.ContentResourceHandler;
import com.jslsolucoes.tagria.lib.v4.handler.impl.LocaleResourceHandler;
import com.jslsolucoes.tagria.lib.v4.handler.impl.CacheableResourceHandler;

@SuppressWarnings("serial")
@WebServlet(name = "tagria-servlet-v4", urlPatterns = "/tagria/v4/*", loadOnStartup = 1)
public class TagriaServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	    throws ServletException, IOException {

	List<ResourceHandler> handlers = Arrays.asList(new BlankResourceHandler(), new LocaleResourceHandler(),
		new CacheableResourceHandler(), new ContentResourceHandler());
	for (ResourceHandler tagriaHandler : handlers) {
	    if (tagriaHandler.accepts(httpServletRequest)) {
		tagriaHandler.handle(httpServletRequest, httpServletResponse);
	    }
	}
    }
}
