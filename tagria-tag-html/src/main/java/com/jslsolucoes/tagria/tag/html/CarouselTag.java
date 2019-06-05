package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CarouselTag extends AbstractSimpleTagSupport {

	@Override
	public Element render() {
		return div(idForId(id));
	}

	private Element aNext(String id) {
		return ElementCreator.newA().attribute(Attribute.CLASS, "carousel-control-next")
				.attribute(Attribute.HREF, "#" + id).attribute(Attribute.DATA_SLIDE, "next")
				.add(ElementCreator.newSpan().attribute(Attribute.CLASS, "carousel-control-next-icon"));
	}

	private Element aPrev(String id) {
		return ElementCreator.newA().attribute(Attribute.CLASS, "carousel-control-prev")
				.attribute(Attribute.HREF, "#" + id).attribute(Attribute.DATA_SLIDE, "prev")
				.add(ElementCreator.newSpan().attribute(Attribute.CLASS, "carousel-control-prev-icon"));
	}

	private Element divInner() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "carousel-inner").add(bodyContent());
	}

	private Element div(String id) {
		return ElementCreator.newDiv().attribute(Attribute.ID, id).attribute(Attribute.CLASS, "carousel slide")
				.attribute(Attribute.DATA_RIDE, "carousel").add(divInner()).add(aPrev(id)).add(aNext(id));
	}

}