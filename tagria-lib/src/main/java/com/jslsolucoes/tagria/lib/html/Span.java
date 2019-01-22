
package com.jslsolucoes.tagria.lib.html;

public class Span extends Element {

	@Override
	public String getTag() {
		return "span";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}
}
