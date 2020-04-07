
package com.jslsolucoes.tagria.tag.html.v4.tag.input;

import java.util.Map;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractIterableSimpleTagSupport;

@SuppressWarnings("rawtypes")
public class DataListTag extends AbstractIterableSimpleTagSupport {

    private Map map;
    private Boolean fixed = Boolean.FALSE;

    @Override
    public Element render() {
	return dataList();
    }

    private Element dataList() {
	Element dataList = ElementCreator.newDataList().attribute(Attribute.ID, idForId(id));
	if (fixed) {
	    dataList.add(bodyContent());
	} else {
	    iterateOver((object) -> dataList.add(bodyContent()));
	}
	return dataList;
    }

    public Map getMap() {
	return map;
    }

    public void setMap(Map map) {
	this.map = map;
    }

    public Boolean getFixed() {
	return fixed;
    }

    public void setFixed(Boolean fixed) {
	this.fixed = fixed;
    }

}
