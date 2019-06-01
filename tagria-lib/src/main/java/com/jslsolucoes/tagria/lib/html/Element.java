
package com.jslsolucoes.tagria.lib.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Element {
	private List<Element> elements = new ArrayList<>();
	private Map<String, String> attributes = new HashMap<>();
	
	
	public Element add(String html) {
		return add(new CData(html));
	}
	
	public Element add(Element element) {
		return add(Arrays.asList(element));
	}

	public Element add(List<Element> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public String get(Attribute attribute) {
		return get(attribute.getName());
	}
	
	public String get(String attribute) {
		return attributes.get(attribute);
	}
	
	public Element add(Attribute attribute, Boolean value) {
		return add(attribute.getName(), String.valueOf(value));
	}

	public Element add(Attribute attribute, Integer value) {
		return add(attribute.getName(), String.valueOf(value));
	}
	
	public Element add(Attribute attribute, String value) {
		return add(attribute.getName(), String.valueOf(value));
	}
	
	public Element add(String attribute, String value) {
		String newValue = value.trim();
		if (attributes.containsKey(attribute)) {
			String separator = "style".equals(attribute) ? ";" : " ";
			newValue = get(attribute).concat(separator).concat(newValue);
		}
		attributes.put(attribute, newValue);
		return this;
	}

	public String getHtml() {
		StringBuilder html = new StringBuilder();
		html.append("<");
		html.append(getTag());
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			html.append(" ".concat(entry.getKey()).concat("=\"").concat(entry.getValue()).concat("\""));
		}
		if (this.elements.isEmpty() && !forceCloseTagWithEmptyBody()) {
			html.append("/");
		}
		html.append(">");
		for (Element element : this.elements) {
			html.append(element.getHtml());
		}
		if (!this.elements.isEmpty() || forceCloseTagWithEmptyBody()) {
			html.append("</" + getTag() + ">");
		}
		return html.toString();
	}

	public abstract String getTag();

	public boolean forceCloseTagWithEmptyBody() {
		return false;
	}

}
