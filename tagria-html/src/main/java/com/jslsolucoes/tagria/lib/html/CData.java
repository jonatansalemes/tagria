
package com.jslsolucoes.tagria.lib.html;

public class CData extends Element {

	private String value;

	public CData(String value) {
		this.value = value;
	}

	@Override
	public String getTag() {
		return "";
	}

	@Override
	public String getHtml() {
		return value;
	}
}
