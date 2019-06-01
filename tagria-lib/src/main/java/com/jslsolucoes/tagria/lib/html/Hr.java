
package com.jslsolucoes.tagria.lib.html;

public class Hr extends Element {

	@Override
	public String getTag() {
		return "hr";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}

}
