
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

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
	private List<String> jsScripts = new ArrayList<>();

	public void jsCode(String jsCode) {
		this.jsScripts.add(jsCode);
	}

	@Override
	public void doTag() throws JspException, IOException {
		out(docTypeHtml5());
		out(html());
	}

	public static void main(String[] args) {
		System.out.println(Locale.getDefault().getLanguage() + Locale.getDefault().getCountry());
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
		return ElementCreator.newBody().attribute(Attribute.CLASS, cssClass).add(noScript()).add(bodyContent())
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

	private Element noScriptBody() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "alert alert-danger")
				.add(keyForLibrary("app.no.script"));
	}

	private Element noScript() {
		return ElementCreator.newNoScript().add(noScriptBody());
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

	private Element appJs() {
		return ElementCreator.newScript().add(jsCodeForUrlBase()).add(jsCodeForAjaxAnimation())
				.add(jsScripts.stream().collect(Collectors.joining()));
	}

	private Element tagriaCss() {
		return ElementCreator.newLink().attribute(Attribute.REL, "stylesheet").attribute(Attribute.TYPE, "text/css")
				.attribute(Attribute.HREF, pathForCssOnLibrary("tagria-ui.css"));
	}

	private Element tagriaJs() {
		return ElementCreator.newScript().attribute(Attribute.SRC, pathForJavascriptOnLibrary("tagria-ui.js"));
	}

	private String docTypeHtml5() {
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

}
