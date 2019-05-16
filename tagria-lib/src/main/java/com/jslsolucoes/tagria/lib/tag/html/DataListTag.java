
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Datalist;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("rawtypes")
public class DataListTag extends SimpleTagSupport {

	private String id;
	private Collection data;
	private Map map;
	private String var;
	private Boolean fixed = Boolean.FALSE;

	@Override
	public void doTag() throws JspException, IOException {

		Datalist datalist = new Datalist();
		datalist.add(Attribute.ID, TagUtil.getId(id,this));
		if (fixed) {
			datalist.add(TagUtil.getBody(getJspBody()));
		}
		if (!CollectionUtils.isEmpty(data)) {
			for (Object item : data) {
				getJspContext().setAttribute(var, item);
				datalist.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		} else if (map != null) {
			for (Object entry : map.entrySet()) {
				getJspContext().setAttribute(var, entry);
				datalist.add(TagUtil.getBody(getJspBody()));
			}
			getJspContext().setAttribute(var, null);
		}
		TagUtil.out(getJspContext(), datalist);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
		this.data = data;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Boolean getFixed() {
		return fixed;
	}

	public void setFixed(Boolean fixed) {
		this.fixed = fixed;
	}

}
