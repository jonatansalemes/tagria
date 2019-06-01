
package com.jslsolucoes.tagria.lib.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractElement implements Element {

	private List<Element> elements = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<>();

	public AbstractElement add(String html) {
		return add(new CData(html));
	}

	public AbstractElement add(Element element) {
		return add(Arrays.asList(element));
	}

	public AbstractElement add(Element... elements) {
		return add(Arrays.asList(elements));
	}

	public AbstractElement add(List<Element> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public String attribute(Attribute attribute) {
		return attribute(attribute.getName());
	}

	public String attribute(String attribute) {
		return attributes.get(attribute);
	}

	public AbstractElement attribute(Attribute attribute, Boolean attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public AbstractElement attribute(Attribute attribute, Integer attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public AbstractElement attribute(Attribute attribute, String attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public AbstractElement attribute(String attributeName, String attributeValue) {
		String newValue = attributeValue.trim();
		if (attributes.containsKey(attributeName)) {
			String separator = "style".equals(attributeName) ? ";" : " ";
			newValue = attribute(attributeName).concat(separator).concat(newValue);
		}
		attributes.put(attributeName, newValue);
		return this;
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
		for (Element element : elements) {
			html.append(element.html());
		}
		if (!elements.isEmpty() || closeOnEmpty()) {
			html.append("</" + tag() + ">");
		}
		return html.toString();
	}

	public abstract String tag();

	public Boolean closeOnEmpty() {
		return false;
	}

}
