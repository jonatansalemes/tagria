
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.html.Td;
import com.jslsolucoes.tagria.html.Th;
import com.jslsolucoes.tagria.lib.tag.Formattabler;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class GridColumnTag extends SimpleTagSupport implements Formattabler {

	private String label;
	private Boolean booleanType = Boolean.FALSE;
	private Boolean collapsable = Boolean.FALSE;
	private Boolean exportable = Boolean.FALSE;
	private String align = "left";
	private Boolean rendered = Boolean.TRUE;
	private String state;
	private String hideOnViewport;
	private String formatType;
	private String formatMatch;
	private String formatReplace;

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {

			String body = TagUtil.getBody(getJspBody());

			if (collapsable || booleanType) {
				align = "center";
			}

			GridTag grid = TagUtil.findAncestorWithClass(this, GridTag.class);

			Th th = new Th();
			th.attribute(HtmlAttribute.CLASS, "text-" + align);
			if (!StringUtils.isEmpty(hideOnViewport)) {
				th.attribute(HtmlAttribute.CLASS, TagUtil.cssForHideViewport(hideOnViewport));
			}

			if (exportable) {
				th.attribute(HtmlAttribute.CLASS, "grid-column-exportable");
			}
			if (!StringUtils.isEmpty(label)) {
				th.add(TagUtil.getLocalized(label, getJspContext()));
			}
			grid.addTh(th);

			Td td = new Td();
			td.attribute(HtmlAttribute.CLASS, "text-" + align);
			td.attribute(HtmlAttribute.CLASS, "v-align-middle");

			if (!StringUtils.isEmpty(state)) {
				td.attribute(HtmlAttribute.CLASS, "bg-" + state);
			}

			if (!StringUtils.isEmpty(hideOnViewport)) {
				td.attribute(HtmlAttribute.CLASS, TagUtil.cssForHideViewport(hideOnViewport));
			}

			if (exportable) {
				td.attribute(HtmlAttribute.CLASS, "grid-column-exportable");
			}
			if (!StringUtils.isEmpty(body)) {
				Div container = new Div();
				if (collapsable) {
					td.attribute(HtmlAttribute.CLASS, "grid-column-collapsable");
					Span icon = new Span();
					icon.attribute(HtmlAttribute.CLASS, "fas fa-search");
					td.add(icon);
					container.attribute(HtmlAttribute.CLASS, "collapse grid-column-collapsable-content");
				}

				if (!StringUtils.isEmpty(formatType)) {
					container.add(TagUtil.format(formatType, formatMatch, formatReplace, body, getJspContext()));
				} else if (booleanType) {
					if ("1".equals(body) || "true".equals(body)) {
						Span icon = new Span();
						icon.attribute(HtmlAttribute.CLASS, "fas fa-check");
						container.add(icon);
					}
				} else {
					container.add(body);
				}
				td.add(container);
			}
			TagUtil.out(getJspContext(), td);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getBooleanType() {
		return booleanType;
	}

	public void setBooleanType(Boolean booleanType) {
		this.booleanType = booleanType;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Boolean getExportable() {
		return exportable;
	}

	public void setExportable(Boolean exportable) {
		this.exportable = exportable;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHideOnViewport() {
		return hideOnViewport;
	}

	public void setHideOnViewport(String hideOnViewport) {
		this.hideOnViewport = hideOnViewport;
	}

	public Boolean getCollapsable() {
		return collapsable;
	}

	public void setCollapsable(Boolean collapsable) {
		this.collapsable = collapsable;
	}

	@Override
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	@Override
	public void setFormatMatch(String formatMatch) {
		this.formatMatch = formatMatch;
	}

	@Override
	public void setFormatReplace(String formatReplace) {
		this.formatReplace = formatReplace;
	}

}
