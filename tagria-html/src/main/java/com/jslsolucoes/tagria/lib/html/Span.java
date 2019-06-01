
package com.jslsolucoes.tagria.lib.html;

public class Span extends AbstractHtmlTag {

	@Override
	public String tag() {
		return "span";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
