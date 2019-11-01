
package com.jslsolucoes.tagria.html.v4;

public class TextArea extends AbstractElement {

	@Override
	public String tag() {
		return "textarea";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
