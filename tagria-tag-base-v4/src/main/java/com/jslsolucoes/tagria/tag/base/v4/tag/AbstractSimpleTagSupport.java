package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.jstl.core.Config;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;
import com.jslsolucoes.tagria.config.v4.TagriaConfig;
import com.jslsolucoes.tagria.config.v4.xml.TagriaCdnXML;
import com.jslsolucoes.tagria.config.v4.xml.TagriaXML;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.formatter.v4.DataFormatter;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.CloneableJsAppender;
import com.jslsolucoes.tagria.tag.base.v4.GlobalCssAppender;
import com.jslsolucoes.tagria.tag.base.v4.GlobalJsAppender;

public abstract class AbstractSimpleTagSupport extends SimpleTagSupport implements DynamicAttributes {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSimpleTagSupport.class);
    protected Map<String, String> attributes = new WeakHashMap<String, String>();
    protected Boolean rendered = Boolean.TRUE;
    protected String cssClass;
    protected String id;
    public static final String VERSION = "4.0.8.0";

    private String version() {
	return VERSION;
    }

    private JspWriter writer() {
	return jspContext().getOut();
    }

    private JspContext jspContext() {
	return getJspContext();
    }

    public String format(String type, String value) {
	if (!StringUtils.isEmpty(type) && !StringUtils.isEmpty(value)) {
	    return DataFormatter.newInstance().format(type, value, locale());
	}
	return value;
    }

    public void setAttribute(String name, Object value) {
	jspContext().setAttribute(name, value);
    }

    public String contentOfTemplate(String template) {
	String encoding = encoding();
	String jspPath = xml().getTemplates().stream()
		.filter(tagriaTemplateXML -> template.equals(tagriaTemplateXML.getName())).findFirst()
		.orElseThrow(
			() -> new TagriaRuntimeException("Could not find template " + template + " on definitions "))
		.getPath();
	HttpServletRequest httpServletRequest = httpServletRequest();
	HttpServletResponse httpServletResponse = httpServletResponse();
	try (TagriaServletResponseWrapper tagriaServletResponseWrapper = new TagriaServletResponseWrapper(httpServletResponse, encoding)) {
	    httpServletRequest.getRequestDispatcher(jspPath).include(httpServletRequest, tagriaServletResponseWrapper);
	    return tagriaServletResponseWrapper.flush().asString();
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    public String encoding() {
	return xml().getEncoding();
    }

    public void out(String value) {
	try {
	    if (!StringUtils.isEmpty(value)) {
		writer().print(value);
	    }
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    public void out(Element element) {
	out(element.html());
    }

    public List<Element> renders() {
	return Arrays.asList(render());
    }

    public Element render() {
	return ElementCreator.newNull();
    }

    @Override
    public void doTag() throws JspException, IOException {
	Stopwatch stopwatch = Stopwatch.createStarted();
	if (flush()) {
	    flushBodyContent();
	}
	if (rendered()) {
	    renderOnVoid();
	    for (Element element : renders()) {
		out(element);
	    }
	}
	logger.debug("Render time of " + this + " => " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms ");
    }

    public Boolean rendered() {
	return rendered != null && rendered;
    }

    public String idForId(String id) {
	return id(null, id);
    }

    public String idForName(String name) {
	return id(name, null);
    }

    public String id() {
	return id(null, null);
    }

    public String id(String name, String id) {
	String idForComponent = "par_" + RandomStringUtils.randomAlphanumeric(20);
	if (!StringUtils.isEmpty(id)) {
	    idForComponent = id;
	} else if (!StringUtils.isEmpty(name)) {
	    idForComponent = "par_" + name.replaceAll("\\.", "_").replaceAll("\\[([0-9]{1,}|)\\]", "");
	}
	return idForComponent + complementForMultipleFormGroup();
    }

    private String complementForMultipleFormGroup() {
	CloneableJsAppender cloneableJsAppender = findAncestorWithClass(CloneableJsAppender.class);
	if (cloneableJsAppender != null) {
	    return "__" + cloneableJsAppender.index();
	} else {
	    return "";
	}
    }

    public void renderOnVoid() {

    }

    public Boolean flush() {
	return false;
    }

    public PageContext pageContext() {
	return (PageContext) jspContext();
    }

    public HttpSession httpSession() {
	return pageContext().getSession();
    }

    public String contextPath() {
	return httpServletRequest().getContextPath();
    }

    public HttpServletRequest httpServletRequest() {
	return (HttpServletRequest) pageContext().getRequest();
    }

    public HttpServletResponse httpServletResponse() {
	return (HttpServletResponse) pageContext().getResponse();
    }

    private JspFragment jspbody() {
	return getJspBody();
    }

    private void flushBodyContent() {
	bodyContent();
    }

    public String bodyContent() {
	JspFragment jspFragment = jspbody();
	if (jspFragment != null) {
	    try (StringWriter stringWriter = new StringWriter()) {
		jspFragment.invoke(stringWriter);
		return stringWriter.toString().trim();
	    } catch (Exception e) {
		throw new TagriaRuntimeException(e);
	    }
	}
	return "";
    }

    public <T> T findAncestorWithClass(Class<T> ancestorClass) {
	List<T> ancestors = findAncestorsWithClass(ancestorClass);
	if (!CollectionUtils.isEmpty(ancestors)) {
	    return ancestors.get(0);
	}
	return null;
    }

    public <T> List<T> findAncestorsWithClass(Class<T> ancestorClass) {
	return findAncestorsWithAssignable(getParent(), ancestorClass);
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> findAncestorsWithAssignable(JspTag jspTag, Class<T> ancestorClass) {
	List<T> ancestors = new ArrayList<T>();
	if (ancestorClass.isAssignableFrom(jspTag.getClass())) {
	    ancestors.add((T) jspTag);
	} else {
	    JspTag jspTagtParent = parent(jspTag,ancestorClass);
	    if (jspTagtParent != null) {
		ancestors.addAll(findAncestorsWithAssignable(jspTagtParent, ancestorClass));
	    }
	}
	return ancestors;
    }

    private JspTag parent(JspTag jspTag, Class<?> ancestorClass) {
	return super.findAncestorWithClass(jspTag, ancestorClass);
    }

    public Element applyDynamicAttributesOn(Element element) {
	attributes.entrySet().forEach(entry -> {
	    element.attribute(entry.getKey(), entry.getValue());
	});
	return element;
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
	if (!localName.startsWith("data-")) {
	    throw new TagriaRuntimeException("Dynamic attributes must start with data-*. Eg: data-id, data-url ."
		    + localName + " not was recognize as property");
	}
	attributes.put(localName, value.toString());
    }

    public Locale locale() {
	HttpSession httpSession = httpSession();
	Locale locale = Locale.forLanguageTag(xml().getLocale());
	if (Config.get(httpSession, Config.FMT_LOCALE) != null) {
	    locale = (Locale) Config.get(httpSession, Config.FMT_LOCALE);
	}
	return locale;
    }

    public TagriaXML xml() {
	return TagriaConfig.newConfig().xml();
    }

    public Boolean hasKeyOrLabel(String key, String label) {
	return !StringUtils.isEmpty(key) || !StringUtils.isEmpty(label);
    }

    public String keyOrLabel(String key, String label) {
	if (!StringUtils.isEmpty(key)) {
	    return keyForApplication(key);
	} else if (!StringUtils.isEmpty(label)) {
	    return label;
	}
	return "";
    }

    private String keyFor(String key, String bundle, Object... args) {
	Locale locale = locale();
	try {
	    ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle, locale,getClass().getClassLoader());
	    MessageFormat messageFormat = new MessageFormat(resourceBundle.getString(key));
	    return messageFormat.format(args);
	} catch (MissingResourceException e) {
	    logger.warn("could not find key {} resource for bundle {} locale {}",key,bundle,locale, e);
	    return "???" + key + "???";
	}
    }

    public String keyForApplication(String key) {
	return keyFor(key, "messages", new Object[] {});
    }

    public String keyForLibrary(String key, Object... args) {
	return keyFor(key, "messages_tagrialib", args);
    }

    public String keyForLibrary(String key) {
	return keyForLibrary(key, new Object[] {});
    }

    public String pathForBlank() {
	return pathForUrl("/tagria/v4/blank");
    }

    public String pathForCssOnLibrary(String css) {
	return urlBaseForStaticFile() + "/tagria/v4/lib/css/theme/" + xml().getSkin() + "/" + css + "?ver=" + version();
    }

    public String pathForJavascriptOnLibrary(String js) {
	return urlBaseForStaticFile() + "/tagria/v4/lib/js/" + js + "?ver=" + version();
    }

    public String pathForImageOnLibrary(String image) {
	return urlBaseForStaticFile() + "/tagria/v4/lib/image/theme/" + xml().getSkin() + "/" + image + "?ver="
		+ version();
    }

    public String pathForStatic(String src, Boolean cdn) {
	if (cdn) {
	    return pathForStatic(src);
	} else {
	    return contextPath() + src;
	}
    }

    public String pathForStatic(String url) {
	String urlBase = "";
	if (!url.contains("http") && !url.contains("https")) {
	    urlBase = urlBaseForStaticFile();
	}
	return urlBase + url;
    }

    public String pathForUrl(String path) {
	String url = path;
	if (!url.startsWith("javascript") && !url.startsWith("#") && !url.startsWith("http")
		&& !url.startsWith("https")) {
	    url = contextPath() + url;
	}
	return url.replaceAll("\"", "'");
    }

    private String urlBaseForStaticFile() {
	TagriaCdnXML tagriaCdnXML = xml().getCdn();
	return tagriaCdnXML.getEnabled() ? httpScheme() + "://" + tagriaCdnXML.getUrl() : contextPath();
    }

    public String httpScheme() {
	HttpServletRequest httpServletRequest = httpServletRequest();
	if (httpServletRequest.getHeader("X-Forwarded-Protocol") != null) {
	    return httpServletRequest.getHeader("X-Forwarded-Protocol");
	} else {
	    return httpServletRequest.getScheme();
	}
    }

    public String queryString(List<String> excludesParams) {
	try {
	    HttpServletRequest httpServletRequest = httpServletRequest();
	    List<String> queryString = new ArrayList<>();
	    Enumeration<String> en = httpServletRequest.getParameterNames();
	    while (en.hasMoreElements()) {
		String paramName = en.nextElement();
		if (!excludesParams.contains(paramName))
		    queryString.add(
			    paramName + "=" + URLEncoder.encode(httpServletRequest.getParameter(paramName), "UTF-8"));
	    }
	    return StringUtils.join(queryString, '&');
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    public void appendCssCode(String cssCode) {
	GlobalCssAppender globalCssAppender = findAncestorWithClass(GlobalCssAppender.class);
	globalCssAppender.appendCssCode(cssCode);
    }

    public void appendJsCode(String jsCode) {
	GlobalJsAppender globalJsAppender = findAncestorWithClass(GlobalJsAppender.class);
	globalJsAppender.appendJavascriptCode(jsCode);
	CloneableJsAppender cloneableJsAppender = findAncestorWithClass(CloneableJsAppender.class);
	if (cloneableJsAppender != null) {
	    if (cloneableJsAppender.index() == 0) {
		cloneableJsAppender.appendJavascriptCode(jsCode);
	    }
	}
    }

    public void appendCssScript(String url) {
	GlobalCssAppender globalCssAppender = findAncestorWithClass(GlobalCssAppender.class);
	globalCssAppender.appendCssScript(pathForStatic(url));
    }

    public void appendJsScript(String url) {
	GlobalJsAppender globalJsAppender = findAncestorWithClass(GlobalJsAppender.class);
	globalJsAppender.appendJavascriptScript(pathForStatic(url));
    }

    public String attachTo(String attachToSelector, String attachTo) {
	if (StringUtils.isEmpty(attachToSelector)) {
	    return "#" + idForName(attachTo);
	}
	return attachToSelector;
    }

    public Boolean getRendered() {
	return rendered;
    }

    public void setRendered(Boolean rendered) {
	this.rendered = rendered;
    }

    public String getCssClass() {
	return cssClass;
    }

    public void setCssClass(String cssClass) {
	this.cssClass = cssClass;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }
}
