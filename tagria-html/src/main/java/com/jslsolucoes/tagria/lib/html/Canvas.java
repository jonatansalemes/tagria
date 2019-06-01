
package com.jslsolucoes.tagria.lib.html;

public class Canvas extends Element {

	@Override
	public String getTag() {
		return "canvas";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}
}
