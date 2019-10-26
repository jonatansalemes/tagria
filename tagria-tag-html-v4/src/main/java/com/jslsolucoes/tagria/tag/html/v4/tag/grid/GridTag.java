
package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class GridTag extends AbstractSimpleTagSupport {

    private String var;
    private String varStatus;
    private String label;
    private String labelKey;
    private Collection<Object> data;
    private String url = "#";
    private String noRowText;
    private String noRowTextKey;
    private Element paginate;
    private Element export;
    private Element search;
    private Element toolbar;

    @Override
    public Boolean flush() {
	return true;
    }

    @Override
    public Element render() {
	return divGrid();
    }

    private Element divGrid() {
	String id = id();
	Element div = ElementCreator.newDiv()
		.attribute(Attribute.CLASS,"d-flex flex-column")
		.attribute(Attribute.ID, id);
	if (hasKeyOrLabel(labelKey, label)) {
	    div.add(divTitle());
	}
	
	Boolean hasData = !CollectionUtils.isEmpty(data);
	
	Element firstRow = ElementCreator.newDiv()
			.attribute(Attribute.CLASS, "d-flex flex-row justify-content-between align-items-center");
	
	if (toolbar != null) {
	    firstRow.add(toolbar);
	}
	
	Element firstRowSecondColumn = ElementCreator.newDiv().attribute(Attribute.CLASS, "d-flex flex-row justify-content-between align-items-center");
	if (search != null) {
	    firstRowSecondColumn.add(search);
	}
	if (export != null && hasData) {
	    firstRowSecondColumn.add(export);
	}
	firstRow.add(firstRowSecondColumn);
	
	div.add(firstRow);
	div.add(divTable());
	
	if (paginate != null && hasData) {
	    div.add(paginate);
	}

	appendJsCode("$('#" + id + "').grid({ url : '" + pathForUrl(url) + "',queryString:'"
		+ queryString(Arrays.asList("page", "property", "direction", "resultsPerPage")) + "'});");
	return div;
    }

    private Element divTitle() {
	return ElementCreator.newDiv().attribute(Attribute.CLASS, "text-center mb-3").add(h2Title());
    }

    private Element h2Title() {
	return ElementCreator.newH2().attribute(Attribute.CLASS, "text-secondary").add(keyOrLabel(labelKey, label));
    }

    private Element divTable() {
	return ElementCreator.newDiv().add(table());
    }

    private Element table() {
	return ElementCreator.newTable().attribute(Attribute.CLASS, "table table-striped table-hover table-light")
		.add(bodyContent());
    }

    public Collection<Object> getData() {
	return data;
    }

    public void setData(Collection<Object> data) {
	this.data = data;
    }

    public String getVar() {
	return var;
    }

    public void setVar(String var) {
	this.var = var;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getVarStatus() {
	return varStatus;
    }

    public void setVarStatus(String varStatus) {
	this.varStatus = varStatus;
    }

    public String getNoRowText() {
	return noRowText;
    }

    public void setNoRowText(String noRowText) {
	this.noRowText = noRowText;
    }

    public String getLabelKey() {
	return labelKey;
    }

    public void setLabelKey(String labelKey) {
	this.labelKey = labelKey;
    }

    public String getNoRowTextKey() {
	return noRowTextKey;
    }

    public void setNoRowTextKey(String noRowTextKey) {
	this.noRowTextKey = noRowTextKey;
    }

    public Element getPaginate() {
	return paginate;
    }

    public void setPaginate(Element paginate) {
	this.paginate = paginate;
    }

    public Element getSearch() {
	return search;
    }

    public void setSearch(Element search) {
	this.search = search;
    }

    public Element getExport() {
	return export;
    }

    public void setExport(Element export) {
	this.export = export;
    }

    public Element getToolbar() {
	return toolbar;
    }

    public void setToolbar(Element toolbar) {
	this.toolbar = toolbar;
    }

}
