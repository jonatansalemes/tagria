
package com.jslsolucoes.tagria.lib.html;

public class Ul extends AbstractHtmlTag {

	public static Ul newBuilder() {
		return new Ul();
	}

	@Override
	public String tag() {
		return "ul";
	}
}
