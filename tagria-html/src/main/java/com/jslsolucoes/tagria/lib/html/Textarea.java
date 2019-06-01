
package com.jslsolucoes.tagria.lib.html;

public class Textarea extends Element {

	@Override
	public String getTag() {
		return "textarea";
	}

	@Override
	public boolean forceCloseTagWithEmptyBody() {
		return true;
	}

}
