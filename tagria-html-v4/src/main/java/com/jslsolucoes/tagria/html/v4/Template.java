package com.jslsolucoes.tagria.html.v4;

public class Template extends AbstractElement {

    @Override
    public String tag() {
	return "template";
    }

    @Override
    public Boolean closeOnEmpty() {
	return true;
    }

}
