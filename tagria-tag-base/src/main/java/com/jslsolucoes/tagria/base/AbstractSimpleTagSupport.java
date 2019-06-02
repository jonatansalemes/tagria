package com.jslsolucoes.tagria.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.base.config.TagriaConfigParameter;
import com.jslsolucoes.tagria.exception.TagriaRuntimeException;

public abstract class AbstractSimpleTagSupport extends SimpleTagSupport implements DynamicAttributes {

	private static final Logger logger = LoggerFactory.getLogger(AbstractSimpleTagSupport.class);
	private Map<String, String> attributes = new WeakHashMap<String, String>();

	private JspWriter jspWriter() {
		return getJspContext().getOut();
	}

	public void print(String html) throws IOException {
		if (StringUtils.isEmpty(html)) {
			jspWriter().print(html);
		}
	}
	
	@Override
	public abstract void doTag() throws JspException, IOException;

	public PageContext pageContext() {
		return (PageContext) getJspContext();
	}

	public HttpServletRequest httpServletRequest() {
		return (HttpServletRequest) pageContext().getRequest();
	}

	public HttpServletResponse httpServletResponse() {
		return (HttpServletResponse) pageContext().getResponse();
	}

	public String body() {
		JspFragment jspFragment = getJspBody();
		if (jspFragment != null) {
			try (StringWriter body = new StringWriter()) {
				jspFragment.invoke(body);
				return body.toString().trim();
			} catch (Exception e) {
				throw new TagriaRuntimeException(e);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T findAncestorWithClass(Class<T> ancestorClass) {
		return (T) SimpleTagSupport.findAncestorWithClass(this, ancestorClass);
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if (!localName.startsWith("data-")) {
			throw new TagriaRuntimeException(
					"Dynamic attributes must start with data- . Eg.  data-id=\"1\",data-url=\"/start\" ... ");
		}
		attributes.put(localName, value.toString());
	}

	public String getInitParam(TagriaConfigParameter tagriaConfigParameter) {
		InputStream props = AbstractSimpleTagSupport.class.getResourceAsStream("/tagrialib.properties");
		if (props == null) {
			return tagriaConfigParameter.getDefaultValue();
		} else {
			try {
				Properties properties = new Properties();
				properties.load(props);
				String value = (String) properties.get(tagriaConfigParameter.getName());
				if (value == null)
					return tagriaConfigParameter.getDefaultValue();
				return value;
			} catch (IOException exception) {
				logger.warn("Could not load tagrialib.properties", exception);
			}
		}
		return null;
	}

}
