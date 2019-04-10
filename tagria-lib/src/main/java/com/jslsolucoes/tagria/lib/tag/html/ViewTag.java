
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Body;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.DocType;
import com.jslsolucoes.tagria.lib.html.Head;
import com.jslsolucoes.tagria.lib.html.Html;
import com.jslsolucoes.tagria.lib.html.Img;
import com.jslsolucoes.tagria.lib.html.Link;
import com.jslsolucoes.tagria.lib.html.Meta;
import com.jslsolucoes.tagria.lib.html.NoScript;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Title;
import com.jslsolucoes.tagria.lib.servlet.TagriaConfigParameter;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ViewTag extends SimpleTagSupport {

	private String title = "-";
	private Body body = new Body();
	private Boolean ajaxAnimation = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		
		String lang = TagUtil.localization(getJspContext());
		
		Html html = new Html();
		html.add(Attribute.XMLNS, "http://www.w3.org/1999/xhtml");
		html.add(Attribute.LANG, lang);
		Head head = new Head();
		html.add(head);
		Title titleForPage = new Title();
		titleForPage.add(TagUtil.getLocalized(this.title, getJspContext()));
		head.add(titleForPage);

		Meta meta = new Meta();
		meta.add(Attribute.HTTP_EQUIV, "content-type");
		meta.add(Attribute.CONTENT, "text/html;charset=" + TagUtil.getInitParam(TagriaConfigParameter.ENCODING));

		head.add(meta);

		Meta viewport = new Meta();
		viewport.add(Attribute.NAME, "viewport");
		viewport.add(Attribute.CONTENT, "width=device-width, initial-scale=1");

		head.add(viewport);
		
		Link css = new Link();
		css.add(Attribute.REL, "stylesheet");
		css.add(Attribute.TYPE, "text/css");
		css.add(Attribute.HREF, TagUtil.getPathForCssLibResource(getJspContext(), "tagria-ui.css"));
		head.add(css);
		
		Script recaptcha = new Script();
		recaptcha.add(Attribute.SRC, TagUtil.getPathForUrl(getJspContext(), "https://www.google.com/recaptcha/api.js?hl=" + lang));
		head.add(recaptcha);
		
		Script js = new Script();
		js.add(Attribute.SRC, TagUtil.getPathForJsLibResource(getJspContext(), "tagria-ui.js"));
		head.add(js);

		Link favicon = new Link();
		favicon.add(Attribute.REL, "icon");
		favicon.add(Attribute.TYPE, "image/x-icon");
		favicon.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), "/favicon.ico"));
		head.add(favicon);

		StringBuilder jsReady = new StringBuilder();
		jsReady.append("URL_BASE='" + TagUtil.getPathForUrl(getJspContext(), "") + "';");
		if(ajaxAnimation) {
			jsReady.append(
				"$(document).ajaxStart(function(){ $('.ajax-loading').fadeIn(); }).ajaxStop(function(){ $('.ajax-loading').fadeOut(); });");
		}
		Script ready = new Script();
		ready.add(jsReady.toString());
		head.add(ready);

		Div noScriptBody = new Div();
		noScriptBody.add(Attribute.CLASS, "alert alert-danger");
		noScriptBody.add(TagUtil.getLocalizedForLib("app.no.script", getJspContext()));

		NoScript noScript = new NoScript();
		noScript.add(noScriptBody);
		body.add(noScript);

		Img img = new Img();
		img.add(Attribute.SRC, TagUtil.getPathForImageLibResource(getJspContext(), "loading.gif"));
		img.add(Attribute.WIDTH, 100);
		img.add(Attribute.HEIGHT, 100);
		img.add(Attribute.CLASS, "mx-auto d-block");
		img.add(Attribute.ALT,"loading");
		
		Div loading = new Div();
		loading.add(Attribute.CLASS, "fixed-top collapse ajax-loading");
		loading.add(img);
		body.add(loading);

		body.add(TagUtil.minifyHtml(TagUtil.getBody(getJspBody())));
		html.add(body);

		TagUtil.out(getJspContext(), DocType.HTML5);
		TagUtil.out(getJspContext(), html);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Body getBody() {
		return body;
	}

	public Boolean getAjaxAnimation() {
		return ajaxAnimation;
	}

	public void setAjaxAnimation(Boolean ajaxAnimation) {
		this.ajaxAnimation = ajaxAnimation;
	}
}
