
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
@SuppressWarnings("rawtypes")
public class DataListTag extends AbstractSimpleTagSupport {

	private Collection data;
	private Map map;
	private String var;
	private Boolean fixed = Boolean.FALSE;

	@Override
	public Element render() {
		return dataList();
	}

	private Element dataList() {
		Element dataList = ElementCreator.newDataList().attribute(Attribute.ID, idForId(id));
		if (fixed) {
			dataList.add(bodyContent());
		} else if (!CollectionUtils.isEmpty(data)) {
			for (Object item : data) {
				setAttribute(var, item);
				dataList.add(bodyContent());
			}
			setAttribute(var, null);
		} else if (map != null) {
			for (Object entry : map.entrySet()) {
				setAttribute(var, entry);
				dataList.add(bodyContent());
			}
			setAttribute(var, null);
		}
		return dataList;
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