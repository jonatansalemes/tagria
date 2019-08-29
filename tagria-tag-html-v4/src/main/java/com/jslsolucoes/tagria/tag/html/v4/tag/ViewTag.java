
package com.jslsolucoes.tagria.tag.html.v4.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Streams;
import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.SourceFile;
import com.jslsolucoes.tagria.config.v4.TagriaConfigParameter;
import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.GlobalCssAppender;
import com.jslsolucoes.tagria.tag.base.v4.GlobalJsAppender;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class ViewTag extends AbstractSimpleTagSupport implements GlobalJsAppender, GlobalCssAppender {

	private String title;
	private String titleKey;
	private String cssClass = "body-default";
	private Boolean minifyJs = Boolean.TRUE;
	private Boolean minifyHtml = Boolean.TRUE;
	private Boolean minifyCss = Boolean.TRUE;
	private Boolean asFragment = Boolean.FALSE;
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
		if(!asFragment) {
			return Arrays.asList(docTypeHtml5(), html());
		} else {
			return Arrays.asList(fragment());
		}
	}
	
	private Element fragment() {
		Element divRoot = divRoot();
		for(String cssScriptForImport: this.cssScriptsForImport) {
			divRoot.add(ElementCreator.newLink().attribute(Attribute.REL, "stylesheet")
					.attribute(Attribute.TYPE, "text/css").attribute(Attribute.HREF, cssScriptForImport));
		}
		divRoot.add(ElementCreator.newStyle().add(minifyCss(cssScripts())));
		for(String jsScriptForImport: this.jsScriptsForImport) {
			divRoot.add(ElementCreator.newScript().attribute(Attribute.REL, "preload")
					.attribute(Attribute.SRC, jsScriptForImport));
		}
		divRoot.add(ElementCreator.newScript().add(minifyJs(jsScripts())));
		return divRoot;
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
		Element body = ElementCreator.newBody().attribute(Attribute.CLASS, cssClass).add(noScript())
				.add(divRoot()).add(ajaxLoading());
		for (Element cssScriptForImport : cssScriptsForImport()) {
			body.add(cssScriptForImport);
		}
		body.add(appCss());
		for (Element jsScriptForImport : jsScriptsForImport()) {
			body.add(jsScriptForImport);
		}
		body.add(appJs());
		return body;
	}

	private Element divRoot() {
		return ElementCreator.newDiv().attribute(Attribute.ID,"root").add(minifyHtml(bodyContent()));
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
				"text/html;charset=" + propertyValue(TagriaConfigParameter.ENCODING));
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

	private Element appCss() {
		return ElementCreator.newStyle().add(minifyCss(cssScripts()));
	}
	
	private String jsCodeForAjaxAnimation() {
		return "$(document).ajaxStart(function(){$('.ajax-loading').fadeIn();}).ajaxStop(function(){$('.ajax-loading').fadeOut();});";
	}

	private String jsCodeForUrlBase() {
		return "URL_BASE='" + pathForUrl("") + "';";
	}

	private Element appJs() {
		String appJs = minifyJs(Arrays.asList(jsCodeForUrlBase(), jsCodeForAjaxAnimation(), jsScripts()).stream()
				.collect(Collectors.joining()));
		return ElementCreator.newScript().add(appJs);
	}

	private String cssScripts() {
		return cssScripts.stream().collect(Collectors.joining());
	}

	private String jsScripts() {
		return jsScripts.stream().collect(Collectors.joining());
	}

	private List<Element> jsScriptsForImport() {
		return Streams
				.concat(Arrays.asList(pathForJavascriptOnLibrary("tagria-ui.js"),
						pathForUrl("https://www.google.com/recaptcha/api.js?hl=" + lang())).stream(),
						jsScriptsForImport.stream())
				.map(jsScriptForImport -> ElementCreator.newScript().attribute(Attribute.REL, "preload")
						.attribute(Attribute.SRC, jsScriptForImport))
				.collect(Collectors.toList());
	}

	private List<Element> cssScriptsForImport() {
		return Streams
				.concat(Arrays.asList(pathForCssOnLibrary("tagria-ui.css")).stream(), cssScriptsForImport.stream())
				.map(cssScriptForImport -> ElementCreator.newLink().attribute(Attribute.REL, "stylesheet")
						.attribute(Attribute.TYPE, "text/css").attribute(Attribute.HREF, cssScriptForImport))
				.collect(Collectors.toList());
	}

	private Element docTypeHtml5() {
		return ElementCreator.newDocTypeHtml5();
	}

	private Element ajaxLoading() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "fixed-top collapse ajax-loading")
				.add(loadingImage());
	}

	private Element loadingImage() {
		return ElementCreator.newImg().attribute(Attribute.DATA_SRC, pathForImageOnLibrary("loading.gif"))
				.attribute(Attribute.WIDTH, 100).attribute(Attribute.HEIGHT, 100)
				.attribute(Attribute.CLASS, "mx-auto d-block lazyload").attribute(Attribute.ALT, "loading");
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

}
