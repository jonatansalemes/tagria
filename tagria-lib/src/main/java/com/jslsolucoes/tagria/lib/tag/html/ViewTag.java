
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.Body;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.DocType;
import com.jslsolucoes.tagria.html.Head;
import com.jslsolucoes.tagria.html.Html;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Img;
import com.jslsolucoes.tagria.html.Link;
import com.jslsolucoes.tagria.html.Meta;
import com.jslsolucoes.tagria.html.NoScript;
import com.jslsolucoes.tagria.html.Script;
import com.jslsolucoes.tagria.html.Title;
import com.jslsolucoes.tagria.lib.servlet.TagriaConfigParameter;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ViewTag extends SimpleTagSupport {

	private String title = "-";
	private Body body = new Body();
	private Script script = new Script();
	private Boolean ajaxAnimation = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {

		String lang = TagUtil.localization(getJspContext());
		String title = TagUtil.getLocalized(this.title, getJspContext());

		Html html = new Html();
		html.attribute(HtmlAttribute.XMLNS, "http://www.w3.org/1999/xhtml");
		html.attribute(HtmlAttribute.LANG, lang);
		Head head = new Head();
		html.add(head);
		Title titleForPage = new Title();
		titleForPage.add(title);
		head.add(titleForPage);

		Meta meta = new Meta();
		meta.attribute(HtmlAttribute.HTTP_EQUIV, "content-type");
		meta.attribute(HtmlAttribute.CONTENT, "text/html;charset=" + TagUtil.getInitParam(TagriaConfigParameter.ENCODING));

		head.add(meta);

		Meta viewport = new Meta();
		viewport.attribute(HtmlAttribute.NAME, "viewport");
		viewport.attribute(HtmlAttribute.CONTENT, "width=device-width, initial-scale=1");
		head.add(viewport);

		Meta description = new Meta();
		description.attribute(HtmlAttribute.NAME, "description");
		description.attribute(HtmlAttribute.CONTENT, title);
		head.add(description);

		Link favicon = new Link();
		favicon.attribute(HtmlAttribute.REL, "icon");
		favicon.attribute(HtmlAttribute.TYPE, "image/x-icon");
		favicon.attribute(HtmlAttribute.HREF, TagUtil.getPathForUrl(getJspContext(), "/favicon.ico"));
		head.add(favicon);

		Div noScriptBody = new Div();
		noScriptBody.attribute(HtmlAttribute.CLASS, "alert alert-danger");
		noScriptBody.add(TagUtil.getLocalizedForLib("app.no.script", getJspContext()));

		NoScript noScript = new NoScript();
		noScript.add(noScriptBody);
		body.add(noScript);

		script.add("URL_BASE='" + TagUtil.getPathForUrl(getJspContext(), "") + "';");
		if (ajaxAnimation) {
			script.add(
					"$(document).ajaxStart(function(){$('.ajax-loading').fadeIn();}).ajaxStop(function(){$('.ajax-loading').fadeOut();});");
		}

		body.add(TagUtil.removeBreakLines(TagUtil.getBody(getJspBody())));

		Link css = new Link();
		css.attribute(HtmlAttribute.REL, "stylesheet");
		css.attribute(HtmlAttribute.TYPE, "text/css");
		css.attribute(HtmlAttribute.HREF, TagUtil.getPathForCssLibResource(getJspContext(), "tagria-ui.css"));
		body.add(css);

		Script recaptcha = new Script();
		recaptcha.attribute(HtmlAttribute.SRC,
				TagUtil.getPathForUrl(getJspContext(), "https://www.google.com/recaptcha/api.js?hl=" + lang));
		body.add(recaptcha);

		Script js = new Script();
		js.attribute(HtmlAttribute.SRC, TagUtil.getPathForJsLibResource(getJspContext(), "tagria-ui.js"));
		body.add(js);

		body.add(script);
		html.add(body);

		Img img = new Img();
		img.attribute(HtmlAttribute.SRC, TagUtil.getPathForImageLibResource(getJspContext(), "loading.gif"));
		img.attribute(HtmlAttribute.WIDTH, 100);
		img.attribute(HtmlAttribute.HEIGHT, 100);
		img.attribute(HtmlAttribute.CLASS, "mx-auto d-block");
		img.attribute(HtmlAttribute.ALT, "loading");

		Div loading = new Div();
		loading.attribute(HtmlAttribute.CLASS, "fixed-top collapse ajax-loading");
		loading.add(img);
		body.add(loading);

		TagUtil.out(getJspContext(), DocType.HTML5.definition());
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

	public Script getScript() {
		return script;
	}

	public void setScript(Script script) {
		this.script = script;
	}
}
