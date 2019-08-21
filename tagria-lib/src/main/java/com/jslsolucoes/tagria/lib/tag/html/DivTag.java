
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class DivTag extends SimpleTagSupport implements DynamicAttributes {

	private String cssClass;
	private String id;
	private Boolean rendered = Boolean.TRUE;
	protected Map<String, String> attributes = new WeakHashMap<String, String>();

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			Div div = new Div();
			div.add(Attribute.ID, TagUtil.getId(id,this));
			if (!StringUtils.isEmpty(cssClass)) {
				div.add(Attribute.CLASS, cssClass);
			}
			
			attributes.entrySet().forEach(entry -> {
				div.add(entry.getKey(), entry.getValue());
			});
			
			div.add(TagUtil.getBody(getJspBody()));
			TagUtil.out(getJspContext(), div);
		}
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}
	
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if (!localName.startsWith("data-")) {
			throw new RuntimeException("Dynamic attributes must start with data- . Eg.  data-id,data-url... ." + localName + " not was recognize as property" );
		}
		attributes.put(localName, value.toString());
	}

}
