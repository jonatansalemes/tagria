
package com.jslsolucoes.tagria.html;

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
