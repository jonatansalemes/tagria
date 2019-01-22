
package com.jslsolucoes.tagria.lib.html;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public abstract class Element {
	private List<Element> elements = new ArrayList<>();
	private EnumMap<Attribute, String> attributes = new EnumMap<>(Attribute.class);
	
	public Element add(Element element) {
		elements.add(element);
		return this;
	}

	public void remove(Attribute attribute) {
		attributes.remove(attribute);
	}

	public void remove(Attribute attribute, String value) {

		String separator = " ";
		if (attribute.equals(Attribute.STYLE))
			separator = ";";
		String newValue = attributes.get(attribute).replaceAll(value + "(" + separator + "|)", "");
		if (StringUtils.isEmpty(newValue)) {
			remove(attribute);
		} else {
			attributes.put(attribute, newValue);
		}
	}

	public Element add(List<Element> elements) {
		this.elements.addAll(elements);
		return this;
	}

	public String get(Attribute attribute) {
		return attributes.get(attribute);
	}

	public Element add(Attribute attribute, boolean value) {
		return add(attribute, String.valueOf(value));
	}

	public Element add(String html) {
		this.elements.add(new CData(html));
		return this;
	}

	public Element add(Attribute attribute, String attributeValue) {
		String value = attributeValue.trim();
		if (attributes.containsKey(attribute)) {
			String separator = " ";
			if (attribute.equals(Attribute.STYLE))
				separator = ";";
			value = get(attribute).concat(separator).concat(value);
		}
		attributes.put(attribute, value);
		return this;
	}

	public Element add(Attribute attribute, Integer value) {
		return this.add(attribute, String.valueOf(value));
	}

	public String getHtml() {
		StringBuilder html = new StringBuilder();
		html.append("<");
		html.append(this.getTag());
		for (Map.Entry<Attribute, String> entry : attributes.entrySet()) {
			html.append(" ");
			html.append(entry.getKey().getName());
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
		return this.attributes.get(attribute) != null;
	}

	public abstract String getTag();

	public boolean forceCloseTagWithEmptyBody() {
		return false;
	}

}
