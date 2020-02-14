
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class AnimateTag extends AbstractSimpleTagSupport {

    private String attachTo;
    private String attachToSelector;
    private String animation;
    private Integer delay = 0;

    @Override
    public void renderOnVoid() {
	String selector = attachTo(attachToSelector, attachTo);
	appendJsCode("$('" + selector + "').addClass('animated " + animation + " " + "delay-" + delay + "s');");
    }

    public String getAttachTo() {
	return attachTo;
    }

    public void setAttachTo(String attachTo) {
	this.attachTo = attachTo;
    }

    public String getAttachToSelector() {
	return attachToSelector;
    }

    public void setAttachToSelector(String attachToSelector) {
	this.attachToSelector = attachToSelector;
    }

    public String getAnimation() {
	return animation;
    }

    public void setAnimation(String animation) {
	this.animation = animation;
    }

    public Integer getDelay() {
	return delay;
    }

    public void setDelay(Integer delay) {
	this.delay = delay;
    }

}