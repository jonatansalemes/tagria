
package com.jslsolucoes.tagria.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHtmlTag implements HtmlTag {

	private List<HtmlTag> elements = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<>();

	public HtmlTag add(String html) {
		return add(new CData(html));
	}

	public HtmlTag add(HtmlTag element) {
		return add(Arrays.asList(element));
	}

	public HtmlTag add(HtmlTag... elements) {
		return add(Arrays.asList(elements));
	}

	public HtmlTag add(List<HtmlTag> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public HtmlTag attribute(HtmlAttribute attribute, Boolean attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public HtmlTag attribute(HtmlAttribute attribute, Integer attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public HtmlTag attribute(HtmlAttribute attribute, String attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public HtmlTag attribute(String attributeName, String attributeValue) {
		String newAttributeValue = attributeValue.trim();
		if (attributes.containsKey(attributeName)) {
			String separator = "style".equals(attributeName) ? ";" : " ";
			newAttributeValue = attribute(attributeName).concat(separator).concat(newAttributeValue);
		}
		attributes.put(attributeName, newAttributeValue);
		return this;
	}
	
	public String attribute(HtmlAttribute attribute) {
		return attribute(attribute.getName());
	}

	public String attribute(String attribute) {
		return attributes.get(attribute);
	}

	public String html() {
		StringBuilder html = new StringBuilder();
		html.append("<");
		html.append(tag());
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			html.append(" ".concat(entry.getKey()).concat("=\"").concat(entry.getValue()).concat("\""));
		}
		if (this.elements.isEmpty() && !closeOnEmpty()) {
			html.append("/");
		}
		html.append(">");
		for (HtmlTag element : elements) {
			html.append(element.html());
		}
		if (!elements.isEmpty() || closeOnEmpty()) {
			html.append("</" + tag() + ">");
		}
		return html.toString();
	}
	
	public Boolean closeOnEmpty() {
		return false;
	}

}
