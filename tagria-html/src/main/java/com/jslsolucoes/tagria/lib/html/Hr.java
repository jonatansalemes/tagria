
package com.jslsolucoes.tagria.lib.html;

public class Hr extends AbstractHtmlTag {

	@Override
	public String tag() {
		return "hr";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
