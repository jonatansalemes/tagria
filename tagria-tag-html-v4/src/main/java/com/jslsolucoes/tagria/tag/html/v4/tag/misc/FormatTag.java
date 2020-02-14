
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FormatTag extends AbstractSimpleTagSupport {

    private String formatter;

    @Override
    public Element render() {
	return cData();
    }

    private Element cData() {
	return ElementCreator.newCData(format(formatter, bodyContent()));
    }

    public String getFormatter() {
	return formatter;
    }

    public void setFormatter(String formatter) {
	this.formatter = formatter;
    }
}
