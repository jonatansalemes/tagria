
package com.jslsolucoes.tagria.lib.html;

public class Script extends AbstractHtmlTag {

	@Override
	public String tag() {
		return "script";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
