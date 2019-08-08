package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class GridColumnDataTag extends AbstractSimpleTagSupport {

	private String align = "left";
	private String state;
	private Boolean exportable = Boolean.FALSE;
	private Boolean booleanType = Boolean.FALSE;
	private Boolean collapsable = Boolean.FALSE;

	@Override
	public Element render() {
		return td();
	}

	private Element td() {
		Element td = ElementCreator.newTd().attribute(Attribute.CLASS, "text-" + align).attribute(Attribute.CLASS,
				"v-align-middle");

		if (!StringUtils.isEmpty(state)) {
			td.attribute(Attribute.CLASS, "bg-" + state);
		}

		if (exportable) {
			td.attribute(Attribute.CLASS, "grid-column-exportable");
		}
		
		if (!StringUtils.isEmpty(cssClass)) {
			td.attribute(Attribute.CLASS, cssClass);
		}

		if (collapsable) {
			td.attribute(Attribute.CLASS, "grid-column-collapsable");
			td.add(spanSearch());
		}
		td.add(divContent());
		return td;
	}

	private Element divContent() {
		Element div = ElementCreator.newDiv();
		if (collapsable) {
			div.attribute(Attribute.CLASS, "collapse grid-column-collapsable-content");
		}
		if (booleanType) {
			if(isTrue()) {
				div.add(spanCheck());
			}
		} else {
			div.add(bodyContent());
		}
		return div;
	}

	private boolean isTrue() {
		return bodyContent().trim().matches("(1|true)");
	}

	private Element spanCheck() {
		return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-check");
	}

	private Element spanSearch() {
		return ElementCreator.newSpan().attribute(Attribute.CLASS, "fas fa-search");
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getExportable() {
		return exportable;
	}

	public void setExportable(Boolean exportable) {
		this.exportable = exportable;
	}

	public Boolean getBooleanType() {
		return booleanType;
	}

	public void setBooleanType(Boolean booleanType) {
		this.booleanType = booleanType;
	}

	public Boolean getCollapsable() {
		return collapsable;
	}

	public void setCollapsable(Boolean collapsable) {
		this.collapsable = collapsable;
	}
}
