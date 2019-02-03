
package com.jslsolucoes.tagria.lib.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.servlet.TagriaConfigParameter;
import com.jslsolucoes.tagria.lib.tag.x.StringUtil;

public class TagUtil {

	public static final String VERSION = "3.0.1.8";
	private static Logger logger = LoggerFactory.getLogger(TagUtil.class);

	private TagUtil() {

	}

	public static String localization(JspContext jspContext) {
		Locale locale = locale(jspContext);
		List<String> fullLocale = new ArrayList<String>();
		fullLocale.add(locale.getLanguage());
		if (!StringUtils.isEmpty(locale.getCountry())) {
			fullLocale.add(locale.getCountry());
		}
		return StringUtils.join(fullLocale, "-");
	}

	public static Locale locale(JspContext jspContext) {
		HttpSession httpSession = ((PageContext) jspContext).getSession();
		Locale locale = Locale.forLanguageTag(getInitParam(TagriaConfigParameter.LOCALE));
		if (Config.get(httpSession, Config.FMT_LOCALE) != null) {
			locale = (Locale) Config.get(httpSession, Config.FMT_LOCALE);
		}
		return locale;
	}

	public static String format(String type, String value, JspContext jspContext) {
		return StringUtil.format(type, value, locale(jspContext));
	}

	public static String getId(String name, String id, SimpleTagSupport simpleTagSupport) {
		String idForComponent = "par_" + RandomStringUtils.randomAlphanumeric(20);
		if (!StringUtils.isEmpty(id)) {
			idForComponent = id;
		} else if (!StringUtils.isEmpty(name)) {
			idForComponent = "par_" + name.replaceAll("\\.", "_").replaceAll("\\[([0-9]{1,}|)\\]", "");
		}
		return idForComponent;
	}

	public static String getId(String name, String id) {
		return TagUtil.getId(name, id, null);
	}

	public static String getId() {
		return TagUtil.getId(null, null, null);
	}

	public static String getId(String id) {
		return TagUtil.getId(null, id, null);
	}

	public static String minifyHtml(String value) {
		return value.replaceAll("\r|\t", "");
	}

	public static String getLocalized(String label, JspContext jspContext) {
		if (label.matches("\\{(.*?)\\}")) {
			String key = label.replaceAll("(\\{|\\})", "").trim();
			try {
				return ResourceBundle.getBundle("messages", locale(jspContext)).getString(key);
			} catch (MissingResourceException e) {
				logger.error("could not find key resource", e);
				return '!' + key + '!';
			}
		}
		return label;
	}

	public static String getBody(JspFragment fragment) throws JspException, IOException {
		if (fragment == null)
			return "";
		StringWriter body = new StringWriter();
		fragment.invoke(body);
		body.close();
		return body.toString().trim();
	}

	public static String getInitParam(TagriaConfigParameter tagriaConfigParameter) {
		InputStream props = TagUtil.class.getResourceAsStream("/tagrialib.properties");
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
				logger.error("Could not load tagrialib.properties", exception);
			}
		}
		return null;
	}

	public static String getPathForCssLibResource(JspContext jspContext, String css) {
		return TagUtil.getUrlBaseForStaticFile(jspContext) + "/tagria/lib/css/theme/"
				+ TagUtil.getInitParam(TagriaConfigParameter.SKIN) + "/" + css + "?ver=" + VERSION;
	}

	public static String getPathForJsLibResource(JspContext jspContext, String js) {
		return TagUtil.getUrlBaseForStaticFile(jspContext) + "/tagria/lib/js/" + js + "?ver=" + VERSION;
	}

	public static String getPathForImageLibResource(JspContext jspContext, String image) {
		return TagUtil.getUrlBaseForStaticFile(jspContext) + "/tagria/lib/image/theme/"
				+ TagUtil.getInitParam(TagriaConfigParameter.SKIN) + "/" + image + "?ver=" + VERSION;
	}

	public static String getPathForStatic(JspContext jspContext, String src, Boolean cdn) {
		if (cdn) {
			return getPathForStatic(jspContext, src);
		} else {
			return TagUtil.getContextPath(jspContext) + src;
		}
	}

	public static String getPathForStatic(JspContext jspContext, String url) {
		String urlBase = "";
		if (!url.contains("http") && !url.contains("https")) {
			urlBase = TagUtil.getUrlBaseForStaticFile(jspContext);
		}
		return urlBase + url;
	}

	public static String getPathForUrl(JspContext jspContext, String path) {
		String url = path;
		if (!url.startsWith("javascript") && !url.startsWith("#") && !url.startsWith("http")
				&& !url.startsWith("https")) {
			url = TagUtil.getContextPath(jspContext) + url;
		}
		return url.replaceAll("\"", "'");
	}

	private static String getContextPath(JspContext jspContext) {
		return ((HttpServletRequest) ((PageContext) jspContext).getRequest()).getContextPath();
	}

	private static String getUrlBaseForStaticFile(JspContext jspContext) {
		return TagUtil.getInitParam(TagriaConfigParameter.CDN_URL) != null
				&& Boolean.valueOf(TagUtil.getInitParam(TagriaConfigParameter.CDN_ENABLED))
						? getScheme((HttpServletRequest) ((PageContext) jspContext).getRequest()) + "://"
								+ TagUtil.getInitParam(TagriaConfigParameter.CDN_URL)
						: TagUtil.getContextPath(jspContext);
	}

	public static String getScheme(HttpServletRequest request) {
		if (request.getHeader("X-Forwarded-Protocol") != null) {
			return request.getHeader("X-Forwarded-Protocol");
		} else {
			return request.getScheme();
		}
	}

	public static void out(JspContext jspContext, Element element) throws IOException {
		out(jspContext, element.getHtml());
	}

	public static void out(JspContext jspContext, String content) throws IOException {
		jspContext.getOut().print(content);
	}

	public static String getLocalizedForLib(String key, JspContext jspContext) {
		return getLocalizedForLib(key, jspContext, (Object[]) null);
	}

	public static String getLocalizedForLib(String key, JspContext jspContext, Object... args) {
		try {
			MessageFormat messageFormat = new MessageFormat(
					ResourceBundle.getBundle("messages_tagrialib", locale(jspContext)).getString(key));
			return messageFormat.format(args);
		} catch (MissingResourceException e) {
			logger.error("could not find key resource", e);
			return '!' + key + '!';
		}
	}

	public static String queryString(HttpServletRequest request, List<String> excludesParams)
			throws UnsupportedEncodingException {
		List<String> queryString = new ArrayList<>();
		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String paramName = en.nextElement();
			if (!excludesParams.contains(paramName))
				queryString.add(paramName + "=" + URLEncoder.encode(request.getParameter(paramName), "UTF-8"));
		}
		return StringUtils.join(queryString, '&');
	}

	public static void flushBody(JspFragment fragment) throws JspException, IOException {
		getBody(fragment);
	}

	public static String getPathForBlank(JspContext jspContext) {
		return getPathForUrl(jspContext, "/tagria/blank");
	}

	public static String cssForHideViewport(String hideOnViewport) {
		StringBuilder css = new StringBuilder();
		for (String device : hideOnViewport.split(",")) {
			css.append(" hidden-" + device);
		}
		return css.toString();
	}

	public static String getPathForLocale(JspContext jspContext) {
		return getPathForUrl(jspContext, "/tagria/locale");
	}

	public static String attachTo(String attachToSelector, String attachTo,SimpleTagSupport simpleTagSupport) {
		if(StringUtils.isEmpty(attachToSelector)){
			return "#" + TagUtil.getId(attachTo, null, simpleTagSupport);
		} 
		return attachToSelector;
	}
}
