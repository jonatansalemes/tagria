
package com.jslsolucoes.tagria.tag.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.CompilerOptions.LanguageMode;
import com.google.javascript.jscomp.SourceFile;
import com.jslsolucoes.tagria.config.TagriaConfigParameter;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.base.ViewJsAppender;

public class ViewTag extends AbstractSimpleTagSupport implements ViewJsAppender {

	private String title = "";
	private String key;
	private String cssClass = "body-default";
	private Boolean minifyJs = Boolean.TRUE;
	private Boolean minifyHtml = Boolean.TRUE;
	private List<String> jsScripts = new ArrayList<>();

	public void appendJavascriptCode(String jsCode) {
		this.jsScripts.add(jsCode);
	}

	@Override
	public List<Element> renders() {
		return Arrays.asList(docTypeHtml5(), html());
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
		return ElementCreator.newBody().attribute(Attribute.CLASS, cssClass).add(noScript()).add(minifyHtml(bodyContent()))
				.add(ajaxLoading()).add(tagriaCss()).add(recaptchaJs()).add(tagriaJs()).add(appJs());
	}

	private Element head() {
		return ElementCreator.newHead().add(title()).add(metaContentType()).add(metaViewPort()).add(metaDescription())
				.add(favicon());
	}

	private Element title() {
		return ElementCreator.newTitle().add(titleForApplication());
	}

	private String titleForApplication() {
		return (!StringUtils.isEmpty(key) ? keyForApplication(key) : title);
	}

	private Element favicon() {
		return ElementCreator.newLink().attribute(Attribute.REL, "icon").attribute(Attribute.TYPE, "image/x-icon")
				.attribute(Attribute.HREF, pathForUrl("/favicon.ico"));
	}

	private Element divNoScript() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "alert alert-danger")
				.add(keyForLibrary("app.no.script"));
	}

	private Element noScript() {
		return ElementCreator.newNoScript().add(divNoScript());
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

	private Element recaptchaJs() {
		return ElementCreator.newScript().attribute(Attribute.SRC,
				pathForUrl("https://www.google.com/recaptcha/api.js?hl=" + lang()));
	}

	private String jsCodeForAjaxAnimation() {
		return "$(document).ajaxStart(function(){$('.ajax-loading').fadeIn();}).ajaxStop(function(){$('.ajax-loading').fadeOut();});";
	}

	private String jsCodeForUrlBase() {
		return "URL_BASE='" + pathForUrl("") + "';";
	}
	
	private String minifyHtml(String html) {
		if(minifyHtml) {
			return html.replaceAll("(<.*?>)(\n|\r|\t|\\s)+(<.*?>)","$1$3");
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

	private Element appJs() {
		String appJs = minifyJs(Arrays.asList(jsCodeForUrlBase(), jsCodeForAjaxAnimation(), componentJs()).stream()
				.collect(Collectors.joining()));
		return ElementCreator.newScript().add(appJs);
	}

	private String componentJs() {
		return jsScripts.stream().collect(Collectors.joining());
	}

	private Element tagriaCss() {
		return ElementCreator.newLink().attribute(Attribute.REL, "stylesheet").attribute(Attribute.TYPE, "text/css")
				.attribute(Attribute.HREF, pathForCssOnLibrary("tagria-ui.css"));
	}

	private Element tagriaJs() {
		return ElementCreator.newScript().attribute(Attribute.SRC, pathForJavascriptOnLibrary("tagria-ui.js"));
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
				.attribute(Attribute.CLASS, "mx-auto d-block").attribute(Attribute.ALT, "loading");
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

}
