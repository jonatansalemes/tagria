
package com.jslsolucoes.tagria.lib.html;

public class Div extends AbstractElement {

	@Override
	public String tag() {
		return "div";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
