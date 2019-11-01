
package com.jslsolucoes.tagria.tag.html.v4.tag.phtml;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.Hr;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class HrTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return hr();
	}

	private Element hr() {
		Hr hr = ElementCreator.newHr();
		if (!StringUtils.isEmpty(cssClass)) {
			hr.attribute(Attribute.CLASS, cssClass);
		}
		return hr;
		
	}
}
