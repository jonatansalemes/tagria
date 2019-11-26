
package com.jslsolucoes.tagria.tag.html.v4.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.compressor.v4.CssCompressor;
import com.jslsolucoes.tagria.compressor.v4.HtmlCompressor;
import com.jslsolucoes.tagria.compressor.v4.JsCompressor;
import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.GlobalCssAppender;
import com.jslsolucoes.tagria.tag.base.v4.GlobalJsAppender;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

@SuppressWarnings("unchecked")
public class ViewTag extends AbstractSimpleTagSupport implements GlobalJsAppender, GlobalCssAppender {

    private String title;
    private String titleKey;
    private String cssClass = "body-default";
    private Boolean minifyJs = Boolean.TRUE;
    private Boolean minifyHtml = Boolean.TRUE;
    private Boolean minifyCss = Boolean.TRUE;
    private Boolean dropBack = Boolean.TRUE;
    private Boolean asFragment = Boolean.FALSE;
    private String template;
    private List<String> jsScripts = new ArrayList<>();
    private List<String> cssScripts = new ArrayList<>();
    private List<String> jsScriptsForImport = new ArrayList<>();
    private List<String> cssScriptsForImport = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(ViewTag.class);

    @Override
    public void appendCssCode(String cssCode) {
	this.cssScripts.add(cssCode);
    }

    @Override
    public void appendJavascriptCode(String jsCode) {
	this.jsScripts.add(jsCode);
    }

    @Override
    public void appendJavascriptScript(String url) {
	this.jsScriptsForImport.add(url);
    }

    @Override
    public void appendCssScript(String url) {
	this.cssScriptsForImport.add(url);
    }

    @Override
    public List<Element> renders() {
	if (isTemplatePartial()) {
	    return partial();
	} else {
	    if (!asFragment) {
		return full();
	    } else {
		return fragment();
	    }
	}
    }

    private List<Element> concat(Element... elements) {
	return Arrays.asList(elements);
    }

    private List<Element> concat(List<Element>... lists) {
	return Stream.of(lists).flatMap(x -> x.stream()).collect(Collectors.toList());
    }

    private boolean isTemplatePartial() {
	return !StringUtils.isEmpty(template);
    }

    private List<Element> partial() {
	String templateContent = contentOfTemplate(template);
	String currentContent = asHtml(appHtml());
	String finalContent = recursiveSubstitution(templateContent, currentContent).replace("<!-- template -->",
		asHtml(concat(appCssScriptsForImport(), appCss(), appJsScriptsForImport(), appJs())));
	logger.debug("Final content {}", finalContent);
	return Arrays.asList(ElementCreator.newCData(finalContent));
    }

    private String recursiveSubstitution(String templateContent, String currentContent) {
	Matcher matcher = templatePattern().matcher(templateContent);
	if (matcher.find()) {
	    String fullContent = matcher.group();
	    String attribute = matcher.group(2);
	    String defaultContent = matcher.group(3);
	    String newTemplateContent = templateContent.replace(fullContent,
		    contentOfAttribute(attribute, defaultContent, currentContent));
	    return recursiveSubstitution(newTemplateContent, currentContent);
	} else {
	    return templateContent;
	}
    }

    private String contentOfAttribute(String attribute, String defaultContent, String currentContent) {
	Matcher matcher = templatePattern(attribute).matcher(currentContent);
	if (matcher.find()) {
	    return matcher.group(3);
	} else {
	    return defaultContent;
	}
    }

    private Pattern templatePattern() {
	return templatePattern(".*?");
    }

    private Pattern templatePattern(String render) {
	return Pattern.compile("(<template data-render=\"(" + render + ")\">(.*?)</template>)", Pattern.DOTALL);
    }

    private String asHtml(List<Element> elements) {
	return elements.stream().map(element -> element.html()).collect(Collectors.joining());
    }

    private List<Element> full() {
	return concat(docTypeHtml5(), html());
    }

    private List<Element> fragment() {
	return concat(appHtml(), appCssScriptsForImport(), appCss(), tagriaJsScriptsForImport(),
		appJsScriptsForImport(), appJs());
    }

    private String lang() {
	return language().concat(country());
    }

    private String language() {
	return locale().getLanguage();
    }

    private String country() {
	return (!StringUtils.isEmpty(locale().getCountry()) ? "-" + locale().getCountry() : "");
    }

    private Element html() {
	return ElementCreator.newHtml().attribute(Attribute.XMLNS, "http://www.w3.org/1999/xhtml")
		.attribute(Attribute.LANG, lang()).add(head()).add(body());
    }

    private Element body() {
	return ElementCreator.newBody().attribute(Attribute.CLASS, cssClass).add(noScript()).add(divRoot())
		.add(tagriaCssScriptsForImport()).add(appCssScriptsForImport()).add(appCss())
		.add(tagriaJsScriptsForImport()).add(appJsScriptsForImport()).add(tagriaJs()).add(appJs())
		.add(templateComment());
    }

    private Element templateComment() {
	return ElementCreator.newCData("<!-- template -->");
    }

    private Element divRoot() {
	return ElementCreator.newDiv().attribute(Attribute.ID, "root").add(appHtml());
    }

    private Element head() {
	return ElementCreator.newHead().add(title()).add(metaContentType()).add(metaViewPort()).add(metaDescription())
		.add(favicon());
    }

    private Element title() {
	return ElementCreator.newTitle().add(titleForApplication());
    }

    private String titleForApplication() {
	return (hasKeyOrLabel(titleKey, title) ? keyOrLabel(titleKey, title) : "");
    }

    private Element favicon() {
	return ElementCreator.newLink().attribute(Attribute.REL, "icon").attribute(Attribute.TYPE, "image/x-icon")
		.attribute(Attribute.HREF, pathForUrl("/favicon.ico"));
    }

    private Element noScript() {
	return ElementCreator.newNoScript().add(keyForLibrary("app.no.script"));
    }

    private Element metaDescription() {
	return ElementCreator.newMeta().attribute(Attribute.NAME, "description").attribute(Attribute.CONTENT,
		titleForApplication());
    }

    private Element metaViewPort() {
	return ElementCreator.newMeta().attribute(Attribute.NAME, "viewport").attribute(Attribute.CONTENT,
		"width=device-width, initial-scale=1");
    }

    private Element metaContentType() {
	return ElementCreator.newMeta().attribute(Attribute.HTTP_EQUIV, "content-type").attribute(Attribute.CONTENT,
		"text/html;charset=" + encoding());
    }

    private String minifyCss(String cssCode) {
	if (minifyCss) {
	    return CssCompressor.newCompressor().compress(cssCode);
	} else {
	    return cssCode;
	}
    }

    private String minifyHtml(String html) {
	if (minifyHtml) {
	    return HtmlCompressor.newCompressor().compress(html);
	} else {
	    return html;
	}
    }

    private String minifyJs(String jsCode) {
	if (minifyJs) {
	    return JsCompressor.newCompressor().compress(jsCode);
	} else {
	    return jsCode;
	}
    }

    private List<Element> appCss() {
	return Arrays.asList(ElementCreator.newStyle().add(minifyCss(cssScripts())));
    }

    private List<Element> appJs() {
	return Arrays.asList(ElementCreator.newScript().add(minifyJs(jsScripts())));
    }

    private List<Element> appHtml() {
	List<Element> elements = new ArrayList<>();
	elements.add(antiCorruptionLayer());
	if (dropBack) {
	    elements.add(dropBackLayer());
	    elements.add(dropBackLayerInlineCss());
	}
	elements.add(ElementCreator.newCData(minifyHtml(bodyContent())));
	return elements;
    }

    private Element antiCorruptionLayer() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "anti-corruption-layer");
    }

    private Element dropBackLayerLoading() {
	return ElementCreator.newDiv()
		.attribute(Attribute.CLASS, "d-flex w-100 h-100 align-items-center justify-content-center")
		.add(spinnerLoading());
    }

    private Element spinnerLoading() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "spinner-border text-primary")
		.add(spinnerLoadingSpan());
    }

    private Element spinnerLoadingSpan() {
	return ElementCreator.newSpan().attribute(Attribute.CLASS, "sr-only").add(keyForLibrary("view.loading"));
    }

    private Element dropBackLayer() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "drop-back-layer").add(dropBackLayerLoading());
    }

    private List<Element> appJsScriptsForImport() {
	return jsScriptsForImport.stream().map(jsScriptForImport -> script(jsScriptForImport))
		.collect(Collectors.toList());
    }

    private List<Element> appCssScriptsForImport() {
	return cssScriptsForImport.stream().map(cssScriptForImport -> style(cssScriptForImport))
		.collect(Collectors.toList());
    }

    private Element style(String href) {
	return ElementCreator.newLink().attribute(Attribute.REL, "stylesheet").attribute(Attribute.TYPE, "text/css")
		.attribute(Attribute.HREF, href);
    }

    private Element script(String src) {
	return ElementCreator.newScript().attribute(Attribute.REL, "preload").attribute(Attribute.SRC, src);
    }

    private Element dropBackLayerInlineCss() {
	String content = ".drop-back-layer{position:fixed;top:0;left:0;z-index:2000;background-color:#fff;width:100%;height:100%}.sr-only{position:absolute;width:1px;height:1px;padding:0;overflow:hidden;clip:rect(0,0,0,0);white-space:nowrap;border:0}.sr-only-focusable:active,.sr-only-focusable:focus{position:static;width:auto;height:auto;overflow:visible;clip:auto;white-space:normal}@-webkit-keyframes spinner-grow{0%{-webkit-transform:scale(0);transform:scale(0)}50%{opacity:1}}@keyframes spinner-grow{0%{-webkit-transform:scale(0);transform:scale(0)}50%{opacity:1}}.spinner-grow{display:inline-block;width:2rem;height:2rem;vertical-align:text-bottom;background-color:currentColor;border-radius:50%;opacity:0;-webkit-animation:spinner-grow .75s linear infinite;animation:spinner-grow .75s linear infinite}.spinner-grow-sm{width:1rem;height:1rem}.text-primary{color:#007bff!important}.d-flex{display:-ms-flexbox!important;display:flex!important}.w-100{width:100%!important}.h-100{height:100%!important}.align-items-center{-ms-flex-align:center!important;align-items:center!important}.justify-content-center{-ms-flex-pack:center!important;justify-content:center!important}";
	return ElementCreator.newStyle().add(content);
    }

    private String cssScripts() {
	return cssScripts.stream().collect(Collectors.joining());
    }

    private String jsScripts() {
	return jsScripts.stream().collect(Collectors.joining());
    }

    private List<Element> tagriaJsScriptsForImport() {
	return Arrays
		.asList(pathForJavascriptOnLibrary("tagria-ui.js"),
			pathForUrl("https://www.google.com/recaptcha/api.js?hl=" + lang()))
		.stream().map(jsScriptForImport -> script(jsScriptForImport)).collect(Collectors.toList());
    }

    private List<Element> tagriaCssScriptsForImport() {
	return Arrays.asList(pathForCssOnLibrary("tagria-ui.css")).stream()
		.map(cssScriptForImport -> style(cssScriptForImport)).collect(Collectors.toList());
    }

    private List<Element> tagriaJs() {
	return Arrays.asList(ElementCreator.newScript().add(minifyJs(tagriaJsScripts())));
    }

    private String tagriaJsScripts() {
	return Arrays.asList(tagriaJsCodeForUrlBase()).stream().collect(Collectors.joining(""));
    }

    private String tagriaJsCodeForUrlBase() {
	return "const URL_BASE='" + pathForUrl("") + "';";
    }

    private Element docTypeHtml5() {
	return ElementCreator.newDocTypeHtml5();
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getCssClass() {
	return cssClass;
    }

    public void setCssClass(String cssClass) {
	this.cssClass = cssClass;
    }

    public Boolean getMinifyJs() {
	return minifyJs;
    }

    public void setMinifyJs(Boolean minifyJs) {
	this.minifyJs = minifyJs;
    }

    public Boolean getMinifyHtml() {
	return minifyHtml;
    }

    public void setMinifyHtml(Boolean minifyHtml) {
	this.minifyHtml = minifyHtml;
    }

    public String getTitleKey() {
	return titleKey;
    }

    public void setTitleKey(String titleKey) {
	this.titleKey = titleKey;
    }

    public Boolean getMinifyCss() {
	return minifyCss;
    }

    public void setMinifyCss(Boolean minifyCss) {
	this.minifyCss = minifyCss;
    }

    public Boolean getAsFragment() {
	return asFragment;
    }

    public void setAsFragment(Boolean asFragment) {
	this.asFragment = asFragment;
    }

    public String getTemplate() {
	return template;
    }

    public void setTemplate(String template) {
	this.template = template;
    }

    public Boolean getDropBack() {
	return dropBack;
    }

    public void setDropBack(Boolean dropBack) {
	this.dropBack = dropBack;
    }

}
