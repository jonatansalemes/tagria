
package com.jslsolucoes.tagria.tag.html.tag;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.html.Td;
import com.jslsolucoes.tagria.html.Th;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridColumnTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private Boolean booleanType = Boolean.FALSE;
	private Boolean collapsable = Boolean.FALSE;
	private Boolean exportable = Boolean.FALSE;
	private String align = "left";
	private String state;

	@Override
	public Element render() {

		String body = bodyContent();

		if (collapsable || booleanType) {
			align = "center";
		}

		GridTag grid = findAncestorWithClass(GridTag.class);

		Th th = new Th();
		th.attribute(Attribute.CLASS, "text-" + align);

		if (exportable) {
			th.attribute(Attribute.CLASS, "grid-column-exportable");
		}
		if (hasKeyOrLabel(labelKey, label)) {
			th.add(keyOrLabel(labelKey, label));
		}
		grid.addTh(th);

		Td td = new Td();
		td.attribute(Attribute.CLASS, "text-" + align);
		td.attribute(Attribute.CLASS, "v-align-middle");

		if (!StringUtils.isEmpty(state)) {
			td.attribute(Attribute.CLASS, "bg-" + state);
		}

		if (exportable) {
			td.attribute(Attribute.CLASS, "grid-column-exportable");
		}
		if (!StringUtils.isEmpty(body)) {
			Div container = new Div();
			if (collapsable) {
				td.attribute(Attribute.CLASS, "grid-column-collapsable");
				Span icon = new Span();
				icon.attribute(Attribute.CLASS, "fas fa-search");
				td.add(icon);
				container.attribute(Attribute.CLASS, "collapse grid-column-collapsable-content");
			}

			if (booleanType) {
				if ("1".equals(body) || "true".equals(body)) {
					Span icon = new Span();
					icon.attribute(Attribute.CLASS, "fas fa-check");
					container.add(icon);
				}
			} else {
				container.add(body);
			}
			td.add(container);
		}
		return td;
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

	public Boolean getCollapsable() {
		return collapsable;
	}

	public void setCollapsable(Boolean collapsable) {
		this.collapsable = collapsable;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
