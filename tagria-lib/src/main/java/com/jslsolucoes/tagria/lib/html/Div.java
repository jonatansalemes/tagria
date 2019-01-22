
package com.jslsolucoes.tagria.lib.html;

public class Div extends Element {

	@Override
	public String getTag() {
		return "div";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}

}
