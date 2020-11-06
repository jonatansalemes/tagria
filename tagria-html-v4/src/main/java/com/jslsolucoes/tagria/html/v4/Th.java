
package com.jslsolucoes.tagria.html.v4;

public class Th extends AbstractElement {

    @Override
    public String tag() {
	return "th";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }
}
