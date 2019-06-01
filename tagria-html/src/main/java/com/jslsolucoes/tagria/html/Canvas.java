
package com.jslsolucoes.tagria.html;

public class Canvas extends AbstractHtmlTag {

	@Override
	public String tag() {
		return "canvas";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
