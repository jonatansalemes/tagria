
package com.jslsolucoes.tagria.tag.html.tag.grid;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.VarStatus;

public class GridBodyDataTag extends AbstractSimpleTagSupport {

	private String var;
	private String varStatus;
	private VarStatus varStatusObject = new VarStatus();
	private Collection<Object> data;
	private String noRowText;
	private String noRowTextKey;

	public Element render() {
		return tbody();
	}

	private Element tbody() {
		Element tbody = ElementCreator.newTBody();
		if (!CollectionUtils.isEmpty(data)) {
			for (Object row : data) {
				setAttribute(var, row);
				if (!StringUtils.isEmpty(varStatus)) {
					setAttribute(varStatus, varStatusObject);
				}
				tbody.add(trContent());
				varStatusObject.increment();
			}
			setAttribute(var, null);
			if (!StringUtils.isEmpty(varStatus)) {
				setAttribute(varStatus, null);
			}
		} else {
			tbody.add(trNoContent());
		}
		return tbody;
	}
	
	private Element trContent() {
		return ElementCreator.newTr().add(bodyContent());
	}

	private Element trNoContent() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "alert alert-info")
				.attribute(Attribute.ROLE, "alert")
				.add((hasKeyOrLabel(noRowTextKey, noRowText) ? keyOrLabel(noRowTextKey, noRowText)
						: keyForLibrary("grid.no.row")));
		Element td = ElementCreator.newTd()
				.attribute(Attribute.COLSPAN,20)
				.add(div);
		return ElementCreator.newTr().add(td);
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getVarStatus() {
		return varStatus;
	}

	public void setVarStatus(String varStatus) {
		this.varStatus = varStatus;
	}

	public Collection<Object> getData() {
		return data;
	}

	public void setData(Collection<Object> data) {
		this.data = data;
	}

	public String getNoRowText() {
		return noRowText;
	}

	public void setNoRowText(String noRowText) {
		this.noRowText = noRowText;
	}

	public String getNoRowTextKey() {
		return noRowTextKey;
	}

	public void setNoRowTextKey(String noRowTextKey) {
		this.noRowTextKey = noRowTextKey;
	}

}
