
package com.jslsolucoes.tagria.library.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslsolucoes.tagria.library.handler.ResourceHandler;
import com.jslsolucoes.tagria.library.handler.impl.BlankResourceHandler;
import com.jslsolucoes.tagria.library.handler.impl.ContentResourceHandler;
import com.jslsolucoes.tagria.library.handler.impl.LocaleResourceHandler;
import com.jslsolucoes.tagria.library.handler.impl.NoneMatchResourceHandler;

@SuppressWarnings("serial")
@WebServlet(name = "tagria", urlPatterns = "/tagria/*", loadOnStartup = 1)
public class Tagria extends HttpServlet {

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {

		List<ResourceHandler> handlers = Arrays.asList(
				new BlankResourceHandler(httpServletRequest, httpServletResponse),
				new LocaleResourceHandler(httpServletRequest, httpServletResponse),
				new NoneMatchResourceHandler(httpServletRequest, httpServletResponse),
				new ContentResourceHandler(httpServletRequest, httpServletResponse));
		for (ResourceHandler tagriaHandler : handlers) {
			if (tagriaHandler.accepts()) {
				tagriaHandler.handle();
			}
		}
	}
}
