
package com.jslsolucoes.tagria.tag.html.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.Form;
import com.jslsolucoes.tagria.html.H2;
import com.jslsolucoes.tagria.html.H5;
import com.jslsolucoes.tagria.html.Input;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.html.Nav;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.html.TBody;
import com.jslsolucoes.tagria.html.THead;
import com.jslsolucoes.tagria.html.Table;
import com.jslsolucoes.tagria.html.Th;
import com.jslsolucoes.tagria.html.Tr;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

@SuppressWarnings({ "rawtypes" })
public class GridTag extends AbstractSimpleTagSupport {

	private String var;
	private String varStatus;
	private Boolean search = Boolean.FALSE;
	private Boolean export = Boolean.FALSE;
	private Boolean paginate = Boolean.FALSE;
	private String label;
	private String labelKey;
	private Collection data;
	private List<Element> ths = new ArrayList<>();
	private Integer resultsPerPage = 60;
	private Integer totalResults;
	private String toolbar;
	private String url = "#";
	private String noRowText;
	private String noRowTextKey;

	@Override
	public Boolean flush() {
		return true;
	}

	@Override
	public Element render() {

		Div container = new Div();
		container.attribute(Attribute.CLASS, "border border-secondary rounded p-2");
		container.attribute(Attribute.ID, id());

		if (hasKeyOrLabel(labelKey, label)) {
			Div title = new Div();
			title.attribute(Attribute.CLASS, "text-center mb-3");
			H2 h2 = new H2();
			h2.attribute(Attribute.CLASS, "text-secondary");
			h2.add(keyOrLabel(labelKey, label));
			title.add(h2);
			container.add(title);
		}

		Div clearfix2 = new Div();
		clearfix2.attribute(Attribute.CLASS, "clearfix");
		container.add(clearfix2);

		if (!StringUtils.isEmpty(toolbar)) {
			Div divForToolbar = new Div();
			divForToolbar.attribute(Attribute.CLASS, "float-left m-2 button-group");
			divForToolbar.add(toolbar);
			clearfix2.add(divForToolbar);
		}

		if (!CollectionUtils.isEmpty(data)) {

			if (totalResults == null) {
				totalResults = data.size();
			}

			if (export) {
				Div divForExportation = new Div();
				divForExportation.attribute(Attribute.CLASS, "float-right m-2");

				Div buttonGroup = new Div();
				buttonGroup.attribute(Attribute.CLASS, "btn-group");

				Button pdf = new Button();
				pdf.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-pdf");
				pdf.attribute(Attribute.TITLE, keyForLibrary("grid.export.pdf"));
				pdf.add(new Span().attribute(Attribute.CLASS, "fa fa-file-pdf"));
				buttonGroup.add(pdf);

				Button excel = new Button();
				excel.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-excel");
				excel.attribute(Attribute.TITLE, keyForLibrary("grid.export.xls"));
				excel.add(new Span().attribute(Attribute.CLASS, "fa fa-file-excel"));
				buttonGroup.add(excel);

				Button csv = new Button();
				csv.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-csv");
				csv.attribute(Attribute.TITLE, keyForLibrary("grid.export.csv"));
				csv.add(new Span().attribute(Attribute.CLASS, "fa fa-file-csv"));
				buttonGroup.add(csv);

				Button xml = new Button();
				xml.attribute(Attribute.CLASS, "btn btn-outline-primary grid-export-xml");
				xml.attribute(Attribute.TITLE, keyForLibrary("grid.export.xml"));
				xml.add(new Span().attribute(Attribute.CLASS, "fa fa-file-code"));
				buttonGroup.add(xml);

				divForExportation.add(buttonGroup);
				clearfix2.add(divForExportation);
			}

			if (search) {
				Div divForSearch = new Div();
				divForSearch.attribute(Attribute.CLASS, "float-right m-5");
				Input input = new Input();
				input.attribute(Attribute.TYPE, "search");
				input.attribute(Attribute.CLASS, "grid-search form-control");
				input.attribute(Attribute.PLACEHOLDER, keyForLibrary("grid.search"));
				divForSearch.add(input);
				clearfix2.add(divForSearch);
			}

			Table table = new Table();
			table.attribute(Attribute.CLASS, "table table-striped table-hover table-light");

			THead thead = new THead();
			Tr tr = new Tr();
			thead.add(tr);
			tr.add(this.ths);
			table.add(thead);

			TBody tbody = new TBody();
			int index = 0;
			for (Object row : data) {
				getJspContext().setAttribute(var, row);
				if (!StringUtils.isEmpty(varStatus)) {
					getJspContext().setAttribute(varStatus, index);
				}
				Tr line = new Tr();
				line.add(bodyContent());
				tbody.add(line);
				index++;
			}
			getJspContext().setAttribute(var, null);
			if (!StringUtils.isEmpty(varStatus)) {
				getJspContext().setAttribute(varStatus, null);
			}

			table.add(tbody);
			container.add(table);

			if (paginate) {

				Div clearfix = new Div();
				clearfix.attribute(Attribute.CLASS, "clearfix");

				HttpServletRequest request = httpServletRequest();
				Integer page = (request.getParameter("page") != null ? Integer.valueOf(request.getParameter("page"))
						: 1);
				Integer resultsPerPage = (request.getParameter("resultsPerPage") != null
						? Integer.valueOf(request.getParameter("resultsPerPage"))
						: this.resultsPerPage);

				Integer toResult = page * resultsPerPage;
				Integer fromResult = (toResult + 1) - resultsPerPage;
				if (toResult >= totalResults) {
					toResult = totalResults;
				}

				Div display = new Div();
				display.attribute(Attribute.CLASS, "float-left m-2");
				display.add(new H5().add(keyForLibrary("grid.page.viewing", fromResult, toResult, totalResults)));
				clearfix.add(display);

				Integer totalOfPages = (int) Math.ceil(Double.valueOf(totalResults) / Double.valueOf(resultsPerPage));

				Div pagination = new Div();
				pagination.attribute(Attribute.CLASS, "float-right m-2");
				Nav nav = new Nav();
				nav.attribute(Attribute.CLASS, "float-left");
				Ul ul = new Ul();
				ul.attribute(Attribute.CLASS, "pagination");
				for (int i = 1; i <= totalOfPages; i++) {
					Li li = new Li();
					li.attribute(Attribute.CLASS, "page-item grid-paginate-item");
					if (i == page) {
						li.attribute(Attribute.CLASS, "active");
					}
					A a = new A();
					a.attribute(Attribute.HREF, "#");
					a.attribute(Attribute.CLASS, "page-link");
					a.add(String.valueOf(i));
					li.add(a);
					ul.add(li);
				}
				nav.add(ul);
				pagination.add(nav);
				clearfix.add(pagination);

				Div divForResultsPerPage = new Div();
				divForResultsPerPage.attribute(Attribute.CLASS, "float-right m-2");

				Div dropdown = new Div();
				dropdown.attribute(Attribute.CLASS, "dropdown dropup");
				dropdown.attribute(Attribute.TITLE, keyForLibrary("grid.results.per.page"));

				Button button = new Button();
				button.attribute(Attribute.CLASS, "btn btn-default dropdown-toggle");
				button.attribute(Attribute.DATA_TOGGLE, "dropdown");
				button.add(String.valueOf(resultsPerPage));

				dropdown.add(button);

				Div results = new Div();
				results.attribute(Attribute.CLASS, "dropdown-menu");
				Integer iteration = 100;
				while (iteration >= 20) {
					A a = new A();
					a.attribute(Attribute.HREF, "#");
					a.attribute(Attribute.CLASS, "dropdown-item grid-results-per-page-item");
					if (iteration == resultsPerPage) {
						a.attribute(Attribute.CLASS, "active");
					}
					a.add(String.valueOf(iteration));
					results.add(a);
					iteration -= 20;
				}
				dropdown.add(results);
				divForResultsPerPage.add(dropdown);
				clearfix.add(divForResultsPerPage);

				container.add(clearfix);
			}

		} else {
			Div noRow = new Div();
			noRow.attribute(Attribute.CLASS, "alert alert-info");
			noRow.attribute(Attribute.ROLE, "alert");
			noRow.add((hasKeyOrLabel(noRowTextKey, noRowText) ? keyOrLabel(noRowTextKey, noRowText)
					: keyForLibrary("grid.no.row")));
			container.add(noRow);
		}

		if (export) {
			Div exporter = new Div();
			exporter.attribute(Attribute.CLASS, "hidden");
			Form form = new Form();
			form.attribute(Attribute.METHOD, "post");
			form.attribute(Attribute.TARGET, "_blank");
			form.attribute(Attribute.CLASS, "grid-export-form");
			form.attribute(Attribute.ACTION, pathForUrl("/tagria-exporter"));
			Input type = new Input();
			type.attribute(Attribute.TYPE, "hidden");
			type.attribute(Attribute.NAME, "type");
			type.attribute(Attribute.CLASS, "grid-export-type");
			form.add(type);
			Input html = new Input();
			html.attribute(Attribute.TYPE, "hidden");
			html.attribute(Attribute.NAME, "json");
			html.attribute(Attribute.CLASS, "grid-export-json");
			form.add(html);
			exporter.add(form);
			container.add(exporter);
		}
		appendJsCode(
				"$('#" + container.attribute(Attribute.ID) + "').grid({ url : '" + pathForUrl(url) + "',queryString:'"
						+ queryString(Arrays.asList("page", "property", "direction", "resultsPerPage")) + "'});");
		return container;
	}

	public Collection getData() {
		return data;
	}

	public void setData(Collection data) {
		this.data = data;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public List<Element> getThs() {
		return ths;
	}

	public void setThs(List<Element> ths) {
		this.ths = ths;
	}

	public void addTh(Th th) {
		ths.add(th);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public Integer getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public Boolean getSearch() {
		return search;
	}

	public void setSearch(Boolean search) {
		this.search = search;
	}

	public Boolean getExport() {
		return export;
	}

	public void setExport(Boolean export) {
		this.export = export;
	}

	public Boolean getPaginate() {
		return paginate;
	}

	public void setPaginate(Boolean paginate) {
		this.paginate = paginate;
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

}
