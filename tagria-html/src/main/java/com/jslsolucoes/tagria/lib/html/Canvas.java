
package com.jslsolucoes.tagria.lib.html;

public class Canvas extends AbstractElement {

	@Override
	public String tag() {
		return "canvas";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
