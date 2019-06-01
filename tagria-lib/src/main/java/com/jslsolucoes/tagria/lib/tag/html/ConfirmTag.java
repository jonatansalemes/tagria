package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.H4;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ConfirmTag extends SimpleTagSupport {

	private String label;
	private String url = "#";
	private String target = "_self";
	private String attachTo;
	private String attachToSelector;

	@Override
	public void doTag() throws JspException, IOException {

		Div modal = new Div();
		modal.attribute(HtmlAttribute.CLASS, "modal fade");
		modal.attribute(HtmlAttribute.ID, TagUtil.getId(this));

		Div dialog = new Div();
		dialog.attribute(HtmlAttribute.CLASS, "modal-dialog modal-sm");

		Div content = new Div();
		content.attribute(HtmlAttribute.CLASS, "modal-content");

		Div header = new Div();
		header.attribute(HtmlAttribute.CLASS, "modal-header");

		H4 h4 = new H4();
		h4.attribute(HtmlAttribute.CLASS, "modal-title");
		h4.add(TagUtil.getLocalizedForLib("confirm.title", getJspContext()));
		header.add(h4);

		Button close = new Button();
		close.attribute(HtmlAttribute.CLASS, "close");
		close.attribute(HtmlAttribute.DATA_DISMISS, "modal");
		close.add(new Span().add("&times;"));
		header.add(close);

		content.add(header);

		Div body = new Div();
		body.attribute(HtmlAttribute.CLASS, "modal-body");

		String bodyContent = TagUtil.getBody(getJspBody());

		if (!StringUtils.isEmpty(bodyContent)) {
			body.add(bodyContent);
		} else if (StringUtils.isEmpty(label)) {
			body.add(TagUtil.getLocalizedForLib("confirm.text", getJspContext()));
		} else {
			body.add(TagUtil.getLocalized(label, getJspContext()));
		}
		content.add(body);

		Div footer = new Div();
		footer.attribute(HtmlAttribute.CLASS, "modal-footer");
		Button cancel = new Button();
		cancel.attribute(HtmlAttribute.CLASS, "btn btn-outline-danger cancel");
		cancel.attribute(HtmlAttribute.DATA_DISMISS, "modal");
		cancel.add(TagUtil.getLocalizedForLib("confirm.cancel", getJspContext()));
		footer.add(cancel);

		A confirm = new A();
		confirm.attribute(HtmlAttribute.CLASS, "btn btn-outline-primary sure");
		confirm.add(TagUtil.getLocalizedForLib("confirm.ok", getJspContext()));
		confirm.attribute(HtmlAttribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
		confirm.attribute(HtmlAttribute.TARGET, target);

		footer.add(confirm);
		content.add(footer);

		dialog.add(content);
		modal.add(dialog);
		TagUtil.out(getJspContext(), modal);

		TagUtil.appendJs(
				"$('" + TagUtil.attachTo(attachToSelector, attachTo, this)
						+ "').attr('data-toggle','modal').attr('data-target','#" + modal.attribute(HtmlAttribute.ID) + "');",
				this);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

}
