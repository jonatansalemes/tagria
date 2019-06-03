
package com.jslsolucoes.tagria.html;

public class Iframe extends AbstractElement {

	@Override
	public String tag() {
		return "iframe";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
