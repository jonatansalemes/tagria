package com.jslsolucoes.tagria.lib.html;

import java.util.List;

public interface Element {

	public Element add(String html);

	public Element add(Element element);

	public Element add(List<Element> elements);

	public Element add(Element... elements);

	public String attribute(Attribute attribute);

	public String attribute(String attribute);

	public Element attribute(String attribute, String attributeValue);

	public String html();

	public String tag();

	public Boolean closeOnEmpty();
}
