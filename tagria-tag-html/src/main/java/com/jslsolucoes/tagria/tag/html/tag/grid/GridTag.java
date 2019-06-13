
package com.jslsolucoes.tagria.tag.html.tag.grid;

import java.util.Arrays;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridTag extends AbstractSimpleTagSupport {

	private String url = "#";
	private Boolean export = Boolean.FALSE;
	private String label;
	private String labelKey;

	public Element render() {
		return div();
	}

	private Element div() {
		String id = id();
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "border border-secondary rounded p-2")
				.attribute(Attribute.ID, id);

		if (hasKeyOrLabel(labelKey, label)) {
			div.add(divTitle());
		}

		if (export) {
			div.add(formExport());
		}
		div.add(bodyContent());
		appendJsCode("$('#" + id + "').grid({ url : '" + pathForUrl(url) + "',queryString:'"
				+ queryString(Arrays.asList("page", "property", "direction", "resultsPerPage")) + "'});");
		return div;

	}

	private Element divTitle() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "text-center mb-3").add(h2());
	}

	private Element h2() {
		return ElementCreator.newH2().attribute(Attribute.CLASS, "text-secondary").add(keyOrLabel(labelKey, label));
	}

	private Element formExport() {
		return ElementCreator.newForm().attribute(Attribute.CLASS, "hidden").attribute(Attribute.METHOD, "post")
				.attribute(Attribute.TARGET, "_blank").attribute(Attribute.CLASS, "grid-export-form")
				.attribute(Attribute.ACTION, pathForUrl("/tagria-exporter")).add(inputType()).add(inputJson());
	}

	private Element inputJson() {
		return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "json")
				.attribute(Attribute.CLASS, "grid-export-json");
	}

	private Element inputType() {
		return ElementCreator.newInput().attribute(Attribute.TYPE, "hidden").attribute(Attribute.NAME, "type")
				.attribute(Attribute.CLASS, "grid-export-type");
	}

}
