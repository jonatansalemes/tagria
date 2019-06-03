
package com.jslsolucoes.tagria.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Iframe;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TabTag extends AbstractSimpleTagSupport {

	private String label;
	private String url;
	
	private Boolean active = Boolean.FALSE;
	private Boolean reloadOnSelect = Boolean.TRUE;

	@Override
	public void render() {
		
			TabPanelTag panel = TagUtil.findAncestorWithClass(this, TabPanelTag.class);

			String id = TagUtil.getId(this);
			Li li = new Li();
			if (reloadOnSelect) {
				li.attribute(Attribute.CLASS, "tab-reload-on-select nav-item");
			}

			A a = new A();
			a.attribute(Attribute.CLASS, "nav-link");
			if (active) {
				a.attribute(Attribute.CLASS, "active");
			}
			a.attribute(Attribute.HREF, "#" + id);
			a.attribute(Attribute.DATA_TOGGLE, "tab");
			a.add(TagUtil.getLocalized(label, getJspContext()));
			li.add(a);

			panel.addLi(li);

			Div div = new Div();
			div.attribute(Attribute.CLASS, "tab-pane m-2");
			if (active) {
				div.attribute(Attribute.CLASS, "active");
			}
			div.attribute(Attribute.ID, id);
			if (StringUtils.isEmpty(url)) {
				div.add(TagUtil.getBody(getJspBody()));
			} else {
				Iframe iframe = new Iframe();
				iframe.attribute(Attribute.CLASS, "iframe");
				iframe.attribute(Attribute.ID, TagUtil.getId(this));
				iframe.attribute(Attribute.SRC, TagUtil.getPathForBlank(getJspContext()));
				iframe.attribute(Attribute.DATA_URL, TagUtil.getPathForUrl(getJspContext(), url));
				if (active) {
					iframe.attribute(Attribute.CLASS, "active");
				}
				div.add(iframe);
				TagUtil.appendJs("$('#" + iframe.attribute(Attribute.ID) + "').iframe();", this);
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
