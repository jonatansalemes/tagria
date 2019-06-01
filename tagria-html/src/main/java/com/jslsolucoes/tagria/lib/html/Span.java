
package com.jslsolucoes.tagria.lib.html;

public class Span extends AbstractElement {

	@Override
	public String tag() {
		return "span";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
