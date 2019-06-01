
package com.jslsolucoes.tagria.lib.html;

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
