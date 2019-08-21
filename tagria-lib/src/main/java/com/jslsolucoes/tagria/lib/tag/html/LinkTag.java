
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.tag.auth.CheckRule;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class LinkTag extends SimpleTagSupport implements DynamicAttributes {

	private String id;
	private String url;
	private String label;
	private String target = "_self";
	private Boolean rendered = Boolean.TRUE;
	private Boolean auth = Boolean.FALSE;
	private String cssClass;
	protected Map<String, String> attributes = new WeakHashMap<String, String>();

	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered && (auth ? TagUtil.allowed(getJspContext(),new CheckRule(url, "GET")) : true)) {
			A a = new A();
			a.add(Attribute.HREF, TagUtil.getPathForUrl(getJspContext(), url));
			a.add(Attribute.TARGET, target);
			a.add(Attribute.ID, TagUtil.getId(id,this));
			
			if (!StringUtils.isEmpty(cssClass)) {
				a.add(Attribute.CLASS, cssClass);
			}
			
			attributes.entrySet().forEach(entry -> {
				a.add(entry.getKey(), entry.getValue());
			});
			
			if (!StringUtils.isEmpty(label)) {
				a.add(TagUtil.getLocalized(label, getJspContext()));
			} else {
				a.add(TagUtil.getBody(getJspBody()));
			}
			TagUtil.out(getJspContext(), a);
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}
	
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		if (!localName.startsWith("data-")) {
			throw new RuntimeException("Dynamic attributes must start with data- . Eg.  data-id,data-url... ." + localName + " not was recognize as property" );
		}
		attributes.put(localName, value.toString());
	}

}
