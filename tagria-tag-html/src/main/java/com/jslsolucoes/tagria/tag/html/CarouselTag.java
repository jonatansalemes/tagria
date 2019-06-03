package com.jslsolucoes.tagria.tag.html;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.AbstractSimpleTagSupport;

public class CarouselTag extends AbstractSimpleTagSupport {

	private String id;

	@Override
	public void render() {

		Div div = new Div();
		div.attribute(Attribute.ID, TagUtil.getId(id, this));
		div.attribute(Attribute.CLASS, "carousel slide");
		div.attribute(Attribute.DATA_RIDE, "carousel");

		Div inner = new Div();
		inner.attribute(Attribute.CLASS, "carousel-inner");
		inner.add(TagUtil.getBody(getJspBody()));

		div.add(inner);

		A prev = new A();
		prev.attribute(Attribute.CLASS, "carousel-control-prev");
		prev.attribute(Attribute.HREF, "#" + div.attribute(Attribute.ID));
		prev.attribute(Attribute.DATA_SLIDE, "prev");
		prev.add(new Span().attribute(Attribute.CLASS, "carousel-control-prev-icon"));
		div.add(prev);

		A next = new A();
		next.attribute(Attribute.CLASS, "carousel-control-next");
		next.attribute(Attribute.HREF, "#" + div.attribute(Attribute.ID));
		next.attribute(Attribute.DATA_SLIDE, "next");
		next.add(new Span().attribute(Attribute.CLASS, "carousel-control-next-icon"));
		div.add(next);

		TagUtil.out(getJspContext(), div);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}