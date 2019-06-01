package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CarouselTag extends SimpleTagSupport {

	private String id;

	@Override
	public void doTag() throws JspException, IOException {

		Div div = new Div();
		div.attribute(HtmlAttribute.ID, TagUtil.getId(id, this));
		div.attribute(HtmlAttribute.CLASS, "carousel slide");
		div.attribute(HtmlAttribute.DATA_RIDE, "carousel");

		Div inner = new Div();
		inner.attribute(HtmlAttribute.CLASS, "carousel-inner");
		inner.add(TagUtil.getBody(getJspBody()));

		div.add(inner);

		A prev = new A();
		prev.attribute(HtmlAttribute.CLASS, "carousel-control-prev");
		prev.attribute(HtmlAttribute.HREF, "#" + div.attribute(HtmlAttribute.ID));
		prev.attribute(HtmlAttribute.DATA_SLIDE, "prev");
		prev.add(new Span().attribute(HtmlAttribute.CLASS, "carousel-control-prev-icon"));
		div.add(prev);

		A next = new A();
		next.attribute(HtmlAttribute.CLASS, "carousel-control-next");
		next.attribute(HtmlAttribute.HREF, "#" + div.attribute(HtmlAttribute.ID));
		next.attribute(HtmlAttribute.DATA_SLIDE, "next");
		next.add(new Span().attribute(HtmlAttribute.CLASS, "carousel-control-next-icon"));
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