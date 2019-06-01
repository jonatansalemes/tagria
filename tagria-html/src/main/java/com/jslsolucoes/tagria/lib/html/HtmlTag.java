package com.jslsolucoes.tagria.lib.html;

import java.util.List;

public interface HtmlTag {
	
	public HtmlTag add(String html);

	public HtmlTag add(HtmlTag element);

	public HtmlTag add(List<HtmlTag> elements);

	public HtmlTag add(HtmlTag... elements);

	public String attribute(Attribute attribute);
	
	public HtmlTag attribute(Attribute attribute, Boolean attributeValue);

	public HtmlTag attribute(Attribute attribute, Integer attributeValue);

	public HtmlTag attribute(Attribute attribute, String attributeValue);

	public String attribute(String attribute);

	public HtmlTag attribute(String attribute, String attributeValue);

	public String html();

	public String tag();

	public Boolean closeOnEmpty();
}
