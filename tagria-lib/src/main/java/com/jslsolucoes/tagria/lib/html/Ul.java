
package com.jslsolucoes.tagria.lib.html;

public class Ul extends Element {
	
	public static Ul newBuilder() {
		return new Ul();
	}

	@Override
	public String getTag() {
		return "ul";
	}
}
