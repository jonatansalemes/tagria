package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.H5;
import com.jslsolucoes.tagria.lib.html.P;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class CarouselItemTag extends SimpleTagSupport {

	private String label;
	private String description;
	private Boolean active = Boolean.FALSE;
	private Boolean rendered = Boolean.TRUE;
	
	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div div = new Div();
			div.add(Attribute.CLASS,"carousel-item");
			
			if(active) {
				div.add(Attribute.CLASS,"active");
			}
			
			div.add(TagUtil.getBody(getJspBody()));
			
			if(!StringUtils.isEmpty(label)){
				Div caption = new Div();
				caption.add(Attribute.CLASS,"carousel-caption d-none d-md-block");
				
				H5 h5 = new H5();
				h5.add(TagUtil.getLocalized(label, getJspContext()));
				caption.add(h5);
				
				if(!StringUtils.isEmpty(description)){
					P p = new P();
					p.add(TagUtil.getLocalized(description, getJspContext()));
					caption.add(p);
				}
				
				div.add(caption);
			}
			TagUtil.out(getJspContext(), div);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

}