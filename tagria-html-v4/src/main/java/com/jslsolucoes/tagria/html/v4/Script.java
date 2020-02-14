
package com.jslsolucoes.tagria.html.v4;

public class Script extends AbstractElement {

    @Override
    public String tag() {
	return "script";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }

}
