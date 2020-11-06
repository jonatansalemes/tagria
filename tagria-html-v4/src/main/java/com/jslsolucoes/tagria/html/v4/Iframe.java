
package com.jslsolucoes.tagria.html.v4;

public class Iframe extends AbstractElement {

    @Override
    public String tag() {
	return "iframe";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }
}
