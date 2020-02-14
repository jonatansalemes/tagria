
package com.jslsolucoes.tagria.tag.html.v4.tag.table;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class TableFooterTag extends AbstractSimpleTagSupport {

    private Boolean dark = Boolean.FALSE;
    private Boolean light = Boolean.FALSE;

    @Override
    public Element render() {
	return tfoot();
    }

    private Element tfoot() {
	return ElementCreator.newTFoot().add(bodyContent());
    }

    public Boolean getDark() {
	return dark;
    }

    public void setDark(Boolean dark) {
	this.dark = dark;
    }

    public Boolean getLight() {
	return light;
    }

    public void setLight(Boolean light) {
	this.light = light;
    }

}
