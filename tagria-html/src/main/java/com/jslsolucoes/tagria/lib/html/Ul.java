
package com.jslsolucoes.tagria.lib.html;

public class Ul extends AbstractElement {

	public static Ul newBuilder() {
		return new Ul();
	}

	@Override
	public String tag() {
		return "ul";
	}
}
