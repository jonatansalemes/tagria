
package com.jslsolucoes.tagria.html.v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class AbstractElement implements Element {

	private List<Element> elements = new ArrayList<>();
	private Map<String, String> attributes = new WeakHashMap<>();

	
	public Element add(String html) {
		return add(new CData(html));
	}

	public Element add(Element element) {
		return add(Arrays.asList(element));
	}

	public Element add(Element... elements) {
		return add(Arrays.asList(elements));
	}

	public Element add(List<Element> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public Element attribute(Attribute attribute, Boolean attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public Element attribute(Attribute attribute, Integer attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public Element attribute(Attribute attribute, String attributeValue) {
		return attribute(attribute.getName(), String.valueOf(attributeValue));
	}

	public Element attribute(String attributeName, String attributeValue) {
		String newAttributeValue = attributeValue.trim();
		if (attributes.containsKey(attributeName)) {
			String separator = "style".equals(attributeName) ? ";" : " ";
			newAttributeValue = attribute(attributeName).concat(separator).concat(newAttributeValue);
		}
		attributes.put(attributeName, newAttributeValue);
		return this;
	}

	public String attribute(Attribute attribute) {
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
		if (elements.isEmpty() && !closeOnEmpty()) {
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

	public Boolean closeOnEmpty() {
		return false;
	}

}
