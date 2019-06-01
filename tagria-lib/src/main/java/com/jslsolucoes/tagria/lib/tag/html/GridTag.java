
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.A;
import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.html.Form;
import com.jslsolucoes.tagria.lib.html.H2;
import com.jslsolucoes.tagria.lib.html.H5;
import com.jslsolucoes.tagria.lib.html.Input;
import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.html.Nav;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Table;
import com.jslsolucoes.tagria.lib.html.Tbody;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.html.Thead;
import com.jslsolucoes.tagria.lib.html.Tr;
import com.jslsolucoes.tagria.lib.html.Ul;
import com.jslsolucoes.tagria.lib.tag.Toolballer;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings({ "rawtypes" })
public class GridTag extends SimpleTagSupport implements Toolballer {

	private String var;
	private String varStatus;
	private Boolean search = Boolean.FALSE;
	private Boolean export = Boolean.FALSE;
	private Boolean paginate = Boolean.FALSE;
	private String label;
	private Collection data;
	private List<Element> ths = new ArrayList<>();
	private Integer resultsPerPage = 60;
	private Integer totalResults;
	private String toolbar;
	private String url = "#";
	private Boolean rendered = Boolean.TRUE;
	private String noRowText;

	@Override
	public void doTag() throws JspException, IOException {

		if (rendered != null && rendered) {

			TagUtil.flushBody(getJspBody());

			Div container = new Div();
			container.add(Attribute.CLASS, "border border-secondary rounded p-2");
			container.add(Attribute.ID, TagUtil.getId(this));

			if (!StringUtils.isEmpty(label)) {
				Div title = new Div();
				title.add(Attribute.CLASS, "text-center mb-3");
				H2 h2 = new H2();
				h2.add(Attribute.CLASS, "text-secondary");
				h2.add(TagUtil.getLocalized(label, getJspContext()));
				title.add(h2);
				container.add(title);
			}

			Div clearfix2 = new Div();
			clearfix2.add(Attribute.CLASS, "clearfix");
			container.add(clearfix2);

			if (!StringUtils.isEmpty(toolbar)) {
				Div divForToolbar = new Div();
				divForToolbar.add(Attribute.CLASS, "float-left m-2 button-group");
				divForToolbar.add(toolbar);
				clearfix2.add(divForToolbar);
			}

			if (!CollectionUtils.isEmpty(data)) {

				if (totalResults == null) {
					totalResults = data.size();
				}

				if (export) {
					Div divForExportation = new Div();
					divForExportation.add(Attribute.CLASS, "float-right m-2");

					Div buttonGroup = new Div();
					buttonGroup.add(Attribute.CLASS, "btn-group");

					Button pdf = new Button();
					pdf.add(Attribute.CLASS, "btn btn-outline-primary grid-export-pdf");
					pdf.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.pdf", getJspContext()));
					pdf.add(new Span().add(Attribute.CLASS, "fa fa-file-pdf"));
					buttonGroup.add(pdf);

					Button excel = new Button();
					excel.add(Attribute.CLASS, "btn btn-outline-primary grid-export-excel");
					excel.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.xls", getJspContext()));
					excel.add(new Span().add(Attribute.CLASS, "fa fa-file-excel"));
					buttonGroup.add(excel);

					Button csv = new Button();
					csv.add(Attribute.CLASS, "btn btn-outline-primary grid-export-csv");
					csv.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.csv", getJspContext()));
					csv.add(new Span().add(Attribute.CLASS, "fa fa-file-csv"));
					buttonGroup.add(csv);

					Button xml = new Button();
					xml.add(Attribute.CLASS, "btn btn-outline-primary grid-export-xml");
					xml.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.export.xml", getJspContext()));
					xml.add(new Span().add(Attribute.CLASS, "fa fa-file-code"));
					buttonGroup.add(xml);

					divForExportation.add(buttonGroup);
					clearfix2.add(divForExportation);
				}

				if (search) {
					Div divForSearch = new Div();
					divForSearch.add(Attribute.CLASS, "float-right m-5");
					Input input = new Input();
					input.add(Attribute.TYPE, "search");
					input.add(Attribute.CLASS, "grid-search form-control");
					input.add(Attribute.PLACEHOLDER, TagUtil.getLocalizedForLib("grid.search", getJspContext()));
					divForSearch.add(input);
					clearfix2.add(divForSearch);
				}

				Table table = new Table();
				table.add(Attribute.CLASS, "table table-striped table-hover table-light");

				Thead thead = new Thead();
				Tr tr = new Tr();
				thead.add(tr);
				tr.add(this.ths);
				table.add(thead);

				Tbody tbody = new Tbody();
				int index = 0;
				for (Object row : data) {
					getJspContext().setAttribute(var, row);
					if (!StringUtils.isEmpty(varStatus)) {
						getJspContext().setAttribute(varStatus, index);
					}
					Tr line = new Tr();
					line.add(TagUtil.getBody(getJspBody()));
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
					clearfix.add(Attribute.CLASS, "clearfix");

					HttpServletRequest request = TagUtil.httpServletRequest(getJspContext());
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
					display.add(Attribute.CLASS, "float-left m-2");
					display.add(new H5().add(TagUtil.getLocalizedForLib("grid.page.viewing", getJspContext(),
							fromResult, toResult, totalResults)));
					clearfix.add(display);

					Integer totalOfPages = (int) Math
							.ceil(Double.valueOf(totalResults) / Double.valueOf(resultsPerPage));

					Div pagination = new Div();
					pagination.add(Attribute.CLASS, "float-right m-2");
					Nav nav = new Nav();
					nav.add(Attribute.CLASS, "float-left");
					Ul ul = new Ul();
					ul.add(Attribute.CLASS, "pagination");
					for (int i = 1; i <= totalOfPages; i++) {
						Li li = new Li();
						li.add(Attribute.CLASS, "page-item grid-paginate-item");
						if (i == page) {
							li.add(Attribute.CLASS, "active");
						}
						A a = new A();
						a.add(Attribute.HREF, "#");
						a.add(Attribute.CLASS, "page-link");
						a.add(String.valueOf(i));
						li.add(a);
						ul.add(li);
					}
					nav.add(ul);
					pagination.add(nav);
					clearfix.add(pagination);

					Div divForResultsPerPage = new Div();
					divForResultsPerPage.add(Attribute.CLASS, "float-right m-2");

					Div dropdown = new Div();
					dropdown.add(Attribute.CLASS, "dropdown dropup");
					dropdown.add(Attribute.TITLE, TagUtil.getLocalizedForLib("grid.results.per.page", getJspContext()));

					Button button = new Button();
					button.add(Attribute.CLASS, "btn btn-default dropdown-toggle");
					button.add(Attribute.DATA_TOGGLE, "dropdown");
					button.add(String.valueOf(resultsPerPage));

					dropdown.add(button);

					Div results = new Div();
					results.add(Attribute.CLASS, "dropdown-menu");
					Integer iteration = 100;
					while (iteration >= 20) {
						A a = new A();
						a.add(Attribute.HREF, "#");
						a.add(Attribute.CLASS, "dropdown-item grid-results-per-page-item");
						if (iteration == resultsPerPage) {
							a.add(Attribute.CLASS, "active");
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
				noRow.add(Attribute.CLASS, "alert alert-info");
				noRow.add(Attribute.ROLE, "alert");
				noRow.add((!StringUtils.isEmpty(noRowText) ? TagUtil.getLocalized(noRowText, getJspContext())
						: TagUtil.getLocalizedForLib("grid.no.row", getJspContext())));
				container.add(noRow);
			}

			if (export) {
				Div exporter = new Div();
				exporter.add(Attribute.CLASS, "hidden");
				Form form = new Form();
				form.add(Attribute.METHOD, "post");
				form.add(Attribute.TARGET, "_blank");
				form.add(Attribute.CLASS, "grid-export-form");
				form.add(Attribute.ACTION, TagUtil.getPathForUrl(getJspContext(), "/tagria/exporter"));
				Input type = new Input();
				type.add(Attribute.TYPE, "hidden");
				type.add(Attribute.NAME, "type");
				type.add(Attribute.CLASS, "grid-export-type");
				form.add(type);
				Input html = new Input();
				html.add(Attribute.TYPE, "hidden");
				html.add(Attribute.NAME, "json");
				html.add(Attribute.CLASS, "grid-export-json");
				form.add(html);
				exporter.add(form);
				container.add(exporter);
			}

			TagUtil.out(getJspContext(), container);
			TagUtil.appendJs("$('#" + container.get(Attribute.ID) + "').grid({ url : '"
					+ TagUtil.getPathForUrl(getJspContext(), url) + "',queryString:'" + TagUtil.queryString(
							getJspContext(), Arrays.asList("page", "property", "direction", "resultsPerPage"))
					+ "'});", this);
		}
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

	@Override
	public void setToolbar(String html) {
		this.toolbar = html;
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

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getNoRowText() {
		return noRowText;
	}

	public void setNoRowText(String noRowText) {
		this.noRowText = noRowText;
	}

}
