
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Iframe;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TabTag extends SimpleTagSupport {

	private String label;
	private String url;
	private Boolean rendered = Boolean.TRUE;
	private Boolean active = Boolean.FALSE;
	private Boolean reloadOnSelect = Boolean.TRUE;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			TabPanelTag panel = TagUtil.findAncestorWithClass(this, TabPanelTag.class);

			String id = TagUtil.getId(this);
			Li li = new Li();
			if (reloadOnSelect) {
				li.attribute(HtmlAttribute.CLASS, "tab-reload-on-select nav-item");
			}

			A a = new A();
			a.attribute(HtmlAttribute.CLASS, "nav-link");
			if (active) {
				a.attribute(HtmlAttribute.CLASS, "active");
			}
			a.attribute(HtmlAttribute.HREF, "#" + id);
			a.attribute(HtmlAttribute.DATA_TOGGLE, "tab");
			a.add(TagUtil.getLocalized(label, getJspContext()));
			li.add(a);

			panel.addLi(li);

			Div div = new Div();
			div.attribute(HtmlAttribute.CLASS, "tab-pane m-2");
			if (active) {
				div.attribute(HtmlAttribute.CLASS, "active");
			}
			div.attribute(HtmlAttribute.ID, id);
			if (StringUtils.isEmpty(url)) {
				div.add(TagUtil.getBody(getJspBody()));
			} else {
				Iframe iframe = new Iframe();
				iframe.attribute(HtmlAttribute.CLASS, "iframe");
				iframe.attribute(HtmlAttribute.ID, TagUtil.getId(this));
				iframe.attribute(HtmlAttribute.SRC, TagUtil.getPathForBlank(getJspContext()));
				iframe.attribute(HtmlAttribute.DATA_URL, TagUtil.getPathForUrl(getJspContext(), url));
				if (active) {
					iframe.attribute(HtmlAttribute.CLASS, "active");
				}
				div.add(iframe);
				TagUtil.appendJs("$('#" + iframe.attribute(HtmlAttribute.ID) + "').iframe();", this);
			}
			panel.addDiv(div);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getReloadOnSelect() {
		return reloadOnSelect;
	}

	public void setReloadOnSelect(Boolean reloadOnSelect) {
		this.reloadOnSelect = reloadOnSelect;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
