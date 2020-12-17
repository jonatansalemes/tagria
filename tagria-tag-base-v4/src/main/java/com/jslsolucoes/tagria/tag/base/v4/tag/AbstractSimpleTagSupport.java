package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.Cookie;
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
import com.jslsolucoes.tagria.api.v4.Authorizer;
import com.jslsolucoes.tagria.api.v4.Tagria;
import com.jslsolucoes.tagria.api.v4.cache.MemoryCache;
import com.jslsolucoes.tagria.config.v4.ConfigurationParser;
import com.jslsolucoes.tagria.config.v4.xml.Configuration;
import com.jslsolucoes.tagria.config.v4.xml.Template;
import com.jslsolucoes.tagria.config.v4.xml.Warning;
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
    private String bodyContent;

    private String version() {
	return Tagria.version();
    }

    public MemoryCache<String, Object> cache() {
	return Tagria.cache();
    }

    private JspWriter writer() {
	return jspContext().getOut();
    }

    private JspContext jspContext() {
	return getJspContext();
    }

    public Authorizer authorizer() {
	return cache().get("authorizer", () -> createAuthorizer(), Authorizer.class);
    }

    @SuppressWarnings({ "unchecked" })
    public List<Element> cacheds(String key, Supplier<Object> elementSupplier) {
	return cache().get("elements:" + key, elementSupplier, List.class);
    }

    public Element cached(String key, Supplier<Object> elementSupplier) {
	return cache().get("element:" + key, elementSupplier, Element.class);
    }

    private Authorizer createAuthorizer() {
	try {
	    return (Authorizer) Class.forName(xml().getSecurity().getClazz()).newInstance();
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    public String format(String type, String value) {
	if (!StringUtils.isEmpty(type) && !StringUtils.isEmpty(value)) {
	    return DataFormatter.newDataFormatter().format(type, value, locale());
	}
	return value;
    }

    public void setAttribute(String name, Object value) {
	jspContext().setAttribute(name, value);
    }

    public String contentOfTemplate(String templateName, Map<String, String> parameters) {

	Template template = xml().getTemplates().stream()
		.filter(templateXml -> templateName.equals(templateXml.getName())).findFirst()
		.orElseThrow(() -> new TagriaRuntimeException(
			"Could not find template " + templateName + " on definitions "));

	String urlBase = xml().getUrlBase();
	String templateUri = template.getUri();
	Boolean cached = template.getCached();
	Boolean ignoreSSL = template.getIgnoreSSL();
	Supplier<Object> templateContentUri = () -> contentOfUri(urlBase, parameters, templateUri, ignoreSSL);
	if (cached) {
	    return cache().get("template:" + templateName, templateContentUri, String.class);
	}
	return String.class.cast(templateContentUri.get());
    }

    private String contentOfUri(String urlBase, Map<String, String> parameters, String templateUri, Boolean ignoreSSL) {
	try {

	    String urlForTemplate = urlFor(urlBase, templateUri, parameters);
	    String cookies = cookies();
	    logger.debug("Ask for render url {} with cookies {}", urlForTemplate, cookies);

	    URL url = new URL(urlForTemplate);
	    URLConnection urlConnection = url.openConnection();
	    urlConnection.addRequestProperty("Cookie", cookies);
	    urlConnection.setDoOutput(true);
	  
	    if(HttpsURLConnection.class.isInstance(urlConnection)) {
		HttpsURLConnection httpsURLConnection = HttpsURLConnection.class.cast(urlConnection);
		httpsURLConnection.setRequestMethod("GET");
		if(Boolean.TRUE.equals(ignoreSSL)) {
		    httpsURLConnection.setHostnameVerifier(hostnameVerifier());
		    httpsURLConnection.setSSLSocketFactory(sslSocketFactory());
		}
	    } else if(HttpURLConnection.class.isInstance(urlConnection)) {
		HttpURLConnection httpURLConnection = HttpURLConnection.class.cast(urlConnection);
		httpURLConnection.setRequestMethod("GET");
	    }
	    
	    urlConnection.connect();
	    try (BufferedReader bufferedReader = new BufferedReader(
		    new InputStreamReader(urlConnection.getInputStream()))) {
		return bufferedReader.lines().collect(Collectors.joining());
	    }
	} catch (Exception e) {
	    throw new TagriaRuntimeException(e);
	}
    }

    public Map<String, String> requestAttributes() {
	HttpServletRequest httpServletRequest = httpServletRequest();
	return Collections.list(httpServletRequest.getAttributeNames()).stream()
		.map(attributeName -> new SimpleEntry<>(attributeName,
			httpServletRequest.getAttribute(attributeName).toString()))
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public Map<String, String> requestParams() {
	return httpServletRequest().getParameterMap().entrySet().stream()
		.map(entry -> new SimpleEntry<>(entry.getKey(), entry.getValue()[0]))
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private HostnameVerifier hostnameVerifier() {
	return (hostName, sslSession) -> true;
    }

    private TrustManager[] trustManagers() {
	TrustManager trustManager = new X509TrustManager() {
	    @Override
	    public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	    }

	    @Override
	    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

	    }

	    @Override
	    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

	    }
	};
	return new TrustManager[] { trustManager };
    }

    private SSLSocketFactory sslSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
	SSLContext sslContext = SSLContext.getInstance("TLS");
	sslContext.init(null, trustManagers(), new SecureRandom());
	return sslContext.getSocketFactory();
    }

    private String cookies() {
	Cookie[] cookies = Optional.ofNullable(httpServletRequest().getCookies()).orElse(new Cookie[0]);
	return Arrays.stream(cookies).map(cookie -> String.format("%s=%s", cookie.getName(), cookie.getValue()))
		.collect(Collectors.joining("&"));
    }

    private String urlFor(String urlBase, String templateUri, Map<String, String> parameters) {
	return urlBase + templateUri + queryParams(parameters);
    }

    @SafeVarargs
    private final String queryParams(Map<String, String>... parameters) {
	String queryParam = Arrays.stream(parameters).map(Map::entrySet).flatMap(Set::stream)
		.map(entry -> String.format("%s=%s", entry.getKey(), encode(entry.getValue(), encoding())))
		.collect(Collectors.joining("&"));
	return Optional.of(queryParam).filter(StringUtils::isNotEmpty).map(queryString -> "?" + queryString).orElse("");
    }

    private String encode(String value, String encoding) {
	try {
	    return URLEncoder.encode(value, encoding);
	} catch (UnsupportedEncodingException e) {
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
	Long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
	Warning warning = xml().getWarning();
	if (warning.getEnabled() && elapsed > warning.getComponentMountTimeThreshold()) {
	    logger.warn("Slow component detected on " + this + " => elapsed " + elapsed + " ms ");
	}

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
	bodyContent = bodyContent();
    }

    public String bodyContent() {
	if (!StringUtils.isEmpty(bodyContent)) {
	    return bodyContent;
	} else {
	    JspFragment jspFragment = jspbody();
	    if (jspFragment != null) {
		try (CharArrayWriter charArrayWriter = new CharArrayWriter()) {
		    jspFragment.invoke(charArrayWriter);
		    return charArrayWriter.toString();
		} catch (Exception e) {
		    throw new TagriaRuntimeException(e);
		}
	    }
	    return "";
	}
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
	    JspTag jspTagtParent = parent(jspTag, ancestorClass);
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

    public Configuration xml() {
	return ConfigurationParser.newParser().parse();
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
	if (args != null && args.length > 0) {
	    return keyForResourceBundle(key, bundle, args);
	} else {
	    return cache().get("resourceBundleKey:" + key + ":" + bundle, () -> keyForResourceBundle(key, bundle, args),
		    String.class);
	}
    }

    private String keyForResourceBundle(String key, String bundle, Object... args) {
	try {
	    ResourceBundle resourceBundle = resourceBundle(bundle);
	    MessageFormat messageFormat = new MessageFormat(resourceBundle.getString(key));
	    return messageFormat.format(args);
	} catch (MissingResourceException e) {
	    logger.warn("could not find key {} resource for bundle {}", key, bundle, e);
	    return "???" + key + "???";
	}
    }

    private ResourceBundle resourceBundle(String bundle) {
	Locale locale = locale();
	return cache().get("resourceBundle:" + bundle + "_" + locale.getDisplayLanguage(),
		() -> ResourceBundle.getBundle(bundle, locale, getClass().getClassLoader()), ResourceBundle.class);
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

    public String javascriptForVoid() {
	return "javascript:void(0)";
    }

    public String pathForUrl(String path) {
	String url = path;
	if (!url.startsWith("javascript") && !url.startsWith("#") && !url.startsWith("http")
		&& !url.startsWith("https")) {
	    url = contextPath() + url;
	}
	return url.replaceAll("\"", "'");
    }

    public static String escapeSimpleQuote(String value) {
	return value.replaceAll("'", "\\\\'");
    }

    public static String escapeAsHtmlDoubleQuote(String value) {
	return value.replaceAll("\"", "&quot;");
    }

    private String urlBaseForStaticFile() {
	return xml().getCdn().getEnabled() ? httpScheme() + "://" + xml().getCdn().getUrl() : contextPath();
    }

    public String httpScheme() {
	HttpServletRequest httpServletRequest = httpServletRequest();
	if (httpServletRequest.getHeader("X-Forwarded-Protocol") != null) {
	    return httpServletRequest.getHeader("X-Forwarded-Protocol");
	} else {
	    return httpServletRequest.getScheme();
	}
    }

    public String queryString(List<String> exclusions) {
	Map<String, String> params = requestParams().entrySet().stream()
		.filter(entry -> !exclusions.contains(entry.getKey()))
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	return queryParams(params);
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
