
package com.jslsolucoes.tagria.html.v4;

public class Div extends AbstractElement {

    @Override
    public String tag() {
	return "div";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }

}
