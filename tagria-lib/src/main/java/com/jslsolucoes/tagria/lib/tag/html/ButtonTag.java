
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.tag.auth.CheckRule;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ButtonTag extends SimpleTagSupport {

	private String id;
	private String type;
	private String url = "#";
	private String icon;
	private String title;
	private Boolean dismiss = Boolean.FALSE;
	private String label;
	private String target = "_self";
	private Boolean rendered = Boolean.TRUE;
	private String cssClass;
	private Boolean disabled = Boolean.FALSE;
	private Boolean autoblock = Boolean.FALSE;
	private Boolean auth = Boolean.FALSE;
	private String state = "primary";

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered
				&& (auth ? TagUtil.allowed(getJspContext(), new CheckRule(url, "GET")) : true)) {
			A a = new A();
			if (!StringUtils.isEmpty(type)) {
				a.attribute(HtmlAttribute.DATA_TYPE, type);
			}
			a.attribute(HtmlAttribute.TARGET, target);
			a.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
			a.attribute(HtmlAttribute.CLASS, "btn btn-outline-" + state + " shadow-sm");

			if (!StringUtils.isEmpty(cssClass)) {
				a.attribute(HtmlAttribute.CLASS, cssClass);
			}

			if (disabled) {
				a.attribute(HtmlAttribute.CLASS, "disabled");
			}

			if (!StringUtils.isEmpty(title)) {
				a.attribute(HtmlAttribute.TITLE, TagUtil.getLocalized(title, getJspContext()));
			}

			if (dismiss) {
				a.attribute(HtmlAttribute.DATA_DISMISS, "modal");
			}

			a.attribute(HtmlAttribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));

			if (!StringUtils.isEmpty(icon)) {
				Span span = new Span();
				span.attribute(HtmlAttribute.CLASS, "fas fa-" + icon);
				a.add(span);
			}

			if (!StringUtils.isEmpty(label)) {
				a.add(" " + TagUtil.getLocalized(label, getJspContext()));
			}

			TagUtil.out(getJspContext(), a);

			if (autoblock) {
				TagUtil.appendJs("$('#" + a.attribute(HtmlAttribute.ID) + "').click(function(){$(this).addClass('disabled');});",
						this);
			}
		}
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getDismiss() {
		return dismiss;
	}

	public void setDismiss(Boolean dismiss) {
		this.dismiss = dismiss;
	}

	public Boolean getAutoblock() {
		return autoblock;
	}

	public void setAutoblock(Boolean autoblock) {
		this.autoblock = autoblock;
	}

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}
}
