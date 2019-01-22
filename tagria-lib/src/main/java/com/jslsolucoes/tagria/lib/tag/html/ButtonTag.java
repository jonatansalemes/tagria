
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
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
	private String state = "primary";

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			A a = new A();
			if (!StringUtils.isEmpty(type)) {
				a.add(Attribute.DATA_TYPE, type);
			}
			a.add(Attribute.TARGET, target);
			a.add(Attribute.ID, TagUtil.getId(id));
			a.add(Attribute.CLASS, "btn btn-outline-" + state + " shadow-sm");

			if (!StringUtils.isEmpty(cssClass)) {
				a.add(Attribute.CLASS, cssClass);
			}

			if (disabled) {
				a.add(Attribute.CLASS, "disabled");
			}

			if (!StringUtils.isEmpty(title)) {
				a.add(Attribute.TITLE, TagUtil.getLocalized(title, getJspContext()));
			}

			if (dismiss) {
				a.add(Attribute.DATA_DISMISS, "modal");
			}

			a.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));

			if (!StringUtils.isEmpty(icon)) {
				Span span = new Span();
				span.add(Attribute.CLASS, "fas fa-" + icon);
				a.add(span);
			}

			if (!StringUtils.isEmpty(label)) {
				a.add(" " + TagUtil.getLocalized(label, getJspContext()));
			}
			
			TagUtil.out(getJspContext(), a);
			
			
			if(autoblock) {
				Script script = new Script();
				script.add(Attribute.TYPE, "text/javascript");
				script.add("$('#" + a.get(Attribute.ID) + "').click(function(){ $(this).addClass('disabled'); });");
				TagUtil.out(getJspContext(), script);
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
}
