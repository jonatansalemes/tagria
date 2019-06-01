
package com.jslsolucoes.tagria.html;

public class Div extends AbstractHtmlTag {

	@Override
	public String tag() {
		return "div";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
