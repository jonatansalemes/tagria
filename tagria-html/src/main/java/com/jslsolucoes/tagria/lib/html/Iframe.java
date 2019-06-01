
package com.jslsolucoes.tagria.lib.html;

public class Iframe extends Element {

	@Override
	public String getTag() {
		return "iframe";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}
}
