package com.jslsolucoes.tagria.html;

import java.util.List;

public interface HtmlTag {
	
	public HtmlTag add(String html);

	public HtmlTag add(HtmlTag element);

	public HtmlTag add(List<HtmlTag> elements);

	public HtmlTag add(HtmlTag... elements);

	public String attribute(HtmlAttribute attribute);
	
	public HtmlTag attribute(HtmlAttribute attribute, Boolean attributeValue);

	public HtmlTag attribute(HtmlAttribute attribute, Integer attributeValue);

	public HtmlTag attribute(HtmlAttribute attribute, String attributeValue);

	public String attribute(String attribute);

	public HtmlTag attribute(String attribute, String attributeValue);

	public String html();

	public String tag();

	public Boolean closeOnEmpty();
}
