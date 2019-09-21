
package com.jslsolucoes.tagria.tag.html.v4.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.SourceFile;
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
    private Boolean asFragment = Boolean.FALSE;
    private String template;
    private List<String> jsScripts = new ArrayList<>();
    private List<String> cssScripts = new ArrayList<>();
    private List<String> jsScriptsForImport = new ArrayList<>();
    private List<String> cssScriptsForImport = new ArrayList<>();

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
	String finalContent = recursiveSubstitution(templateContent,currentContent).replace("<!-- template -->",asHtml(concat(appCssScriptsForImport(), appCss(), appJsScriptsForImport(), appJs())));
	return Arrays.asList(ElementCreator.newCData(finalContent));
    }

    private String recursiveSubstitution(String templateContent, String currentContent) {
	Matcher matcher = templatePattern().matcher(templateContent);
	if (matcher.find()) {
	    String fullContent = matcher.group();
	    String attribute = matcher.group(2);
	    String defaultContent = matcher.group(3);
	    String newTemplateContent = templateContent.replace(fullContent,contentOfAttribute(attribute, defaultContent,currentContent));
	    return recursiveSubstitution(newTemplateContent, currentContent);
	} else {
	    return templateContent;
	}
    }

    private String contentOfAttribute(String attribute,String defaultContent,String currentContent) {
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
	return concat(appHtml(), appCssScriptsForImport(), appCss(), appJsScriptsForImport(), appJs());
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
		.add(ajaxLoading()).add(tagriaCssScriptsForImport()).add(appCssScriptsForImport()).add(appCss())
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
		"text/html;charset=" + xml().getEncoding());
    }

    private String minifyCss(String cssCode) {
	if (minifyCss) {
	    return cssCode.replaceAll("(\n|\r|\t|\\s{2,})", "").replaceAll(" \\{", "{").replaceAll(" ,", ",")
		    .replaceAll(": ", ":").replaceAll(", ", ",");
	} else {
	    return cssCode;
	}
    }

    private String minifyHtml(String html) {
	if (minifyHtml) {
	    return html.replaceAll("(<.*?>)(\n|\r|\t|\\s)+(<.*?>)", "$1$3");
	} else {
	    return html;
	}
    }

    private String minifyJs(String jsCode) {
	if (minifyJs) {
	    Compiler compiler = new Compiler();
	    CompilerOptions options = new CompilerOptions();
	    CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(options);
	    options.setLanguageIn(LanguageMode.ECMASCRIPT5);
	    compiler.compile(SourceFile.fromCode("output.js", ""), SourceFile.fromCode("input.js", jsCode), options);
	    return compiler.toSource();
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
	return Arrays.asList(ElementCreator.newCData(minifyHtml(bodyContent())));
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
	return Arrays.asList(tagriaJsCodeForUrlBase()).stream()
		.collect(Collectors.joining(""));
    }

    private String tagriaJsCodeForUrlBase() {
	return "URL_BASE='" + pathForUrl("") + "';";
    }

    private Element docTypeHtml5() {
	return ElementCreator.newDocTypeHtml5();
    }

    private Element ajaxLoading() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "fixed-top collapse ajax-loading")
		.add(loadingImage());
    }

    private Element loadingImage() {
	return ElementCreator.newImg().attribute(Attribute.SRC, "#")
		.attribute(Attribute.DATA_SRC, pathForImageOnLibrary("loading.gif")).attribute(Attribute.WIDTH, 100)
		.attribute(Attribute.HEIGHT, 100).attribute(Attribute.CLASS, "mx-auto d-block lazyload")
		.attribute(Attribute.ALT, "loading");
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

}
