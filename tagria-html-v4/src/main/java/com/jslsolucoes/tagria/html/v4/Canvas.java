
package com.jslsolucoes.tagria.html.v4;

public class Canvas extends AbstractElement {

    @Override
    public String tag() {
	return "canvas";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }
}
