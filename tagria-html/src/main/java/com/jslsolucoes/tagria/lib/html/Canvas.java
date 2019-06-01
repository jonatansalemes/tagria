
package com.jslsolucoes.tagria.lib.html;

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
