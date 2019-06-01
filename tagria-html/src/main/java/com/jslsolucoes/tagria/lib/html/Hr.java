
package com.jslsolucoes.tagria.lib.html;

public class Hr extends AbstractElement {

	@Override
	public String tag() {
		return "hr";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
