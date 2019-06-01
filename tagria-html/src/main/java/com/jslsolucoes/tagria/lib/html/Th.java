
package com.jslsolucoes.tagria.lib.html;

public class Th extends AbstractElement {

	@Override
	public String tag() {
		return "th";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}
}
