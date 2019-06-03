
package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class ButtonGroupTag extends AbstractSimpleTagSupport {

	@Override
	public void render() {
		out(buttonGroup());
	}

	private Element buttonGroup() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "btn-group").add(bodyContent());
	}
}
