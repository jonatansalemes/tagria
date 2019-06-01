
package com.jslsolucoes.tagria.lib.html;

public class Th extends Element {

	@Override
	public String getTag() {
		return "th";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}
}
