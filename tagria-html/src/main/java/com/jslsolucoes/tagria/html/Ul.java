
package com.jslsolucoes.tagria.html;

public class Ul extends AbstractElement {

	public static Ul newBuilder() {
		return new Ul();
	}

	@Override
	public String tag() {
		return "ul";
	}
}
