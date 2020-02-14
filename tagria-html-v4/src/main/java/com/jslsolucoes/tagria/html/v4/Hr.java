
package com.jslsolucoes.tagria.html.v4;

public class Hr extends AbstractElement {

    @Override
    public String tag() {
	return "hr";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }

}
