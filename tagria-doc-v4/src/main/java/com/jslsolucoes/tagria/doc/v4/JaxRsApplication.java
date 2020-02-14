package com.jslsolucoes.tagria.doc.v4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.mvc.security.Csrf;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jslsolucoes.jax.rs.server.ee.FormUrlEncodedObjectMessageBodyReader;
import com.jslsolucoes.jax.rs.server.ee.FormUrlEncodedStringMessageBodyReader;
import com.jslsolucoes.tagria.doc.v4.controller.AppController;
import com.jslsolucoes.tagria.doc.v4.controller.ComponentController;
import com.jslsolucoes.tagria.doc.v4.controller.IndexController;
import com.jslsolucoes.tagria.doc.v4.controller.StaticContentHandler;

@ApplicationPath("/")
public class JaxRsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
	return new HashSet<Class<?>>(Arrays.asList(IndexController.class, AppController.class,
		ComponentController.class, FormUrlEncodedStringMessageBodyReader.class,
		FormUrlEncodedObjectMessageBodyReader.class, StaticContentHandler.class));
    }

    @Override
    public Map<String, Object> getProperties() {
	final Map<String, Object> map = new HashMap<>();
	map.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.OFF);
	return map;
    }
}
