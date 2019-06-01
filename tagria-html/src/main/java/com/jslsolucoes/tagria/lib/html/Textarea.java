
package com.jslsolucoes.tagria.lib.html;

public class Textarea extends AbstractElement {

	@Override
	public String tag() {
		return "textarea";
	}

	@Override
	public Boolean closeOnEmpty() {
		return true;
	}

}
