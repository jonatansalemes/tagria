
package com.jslsolucoes.tagria.html;

public class Iframe extends AbstractHtmlTag {

	@Override
	public String tag() {
		return "iframe";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
