
package com.jslsolucoes.tagria.lib.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class Element {
	private List<Element> elements = new ArrayList<>();
	private Map<String, String> attributes = new WeakHashMap<>();
	
	public Element add(Element element) {
		elements.add(element);
		return this;
	}
	
	public String get(String attributeName) {
		return attributes.get(attributeName);
	}

	public Element add(List<Element> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public String get(Attribute attribute) {
		return get(attribute.getName());
	}

	public Element add(Attribute attribute, Boolean value) {
		return add(attribute, String.valueOf(value));
	}

	public Element add(String html) {
		this.elements.add(new CData(html));
		return this;
	}
	
	public Element add(Attribute attribute, String attributeValue) {
		return add(attribute.getName(),attributeValue);
	}

	public Element add(String attributeName, String attributeValue) {
		String value = attributeValue.trim();
		if (attributes.containsKey(attributeName)) {
			String separator = " ";
			if ("style".equals(attributeName))
				separator = ";";
			value = get(attributeName).concat(separator).concat(value);
		}
		attributes.put(attributeName, value);
		return this;
	}

	public Element add(Attribute attribute, Integer value) {
		return this.add(attribute, String.valueOf(value));
	}

	public String getHtml() {
		StringBuilder html = new StringBuilder();
		html.append("<");
		html.append(this.getTag());
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			html.append(" ");
			html.append(entry.getKey());
			html.append("=\"");
			html.append(entry.getValue());
			html.append("\"");
		}
		if (this.elements.isEmpty() && !forceCloseTagWithEmptyBody()) {
			html.append("/");
		}
		html.append(">");
		for (Element element : this.elements) {
			html.append(element.getHtml());
		}
		if (!this.elements.isEmpty() || forceCloseTagWithEmptyBody()) {
			html.append("</" + this.getTag() + ">");
		}
		return html.toString();
	}

	public boolean hasAttribute(Attribute attribute) {
		return get(attribute) != null;
	}

	public abstract String getTag();

	public boolean forceCloseTagWithEmptyBody() {
		return false;
	}

}
