
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

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.Form;
import com.jslsolucoes.tagria.html.H2;
import com.jslsolucoes.tagria.html.H5;
import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.HtmlTag;
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
	private List<HtmlTag> ths = new ArrayList<>();
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
			container.attribute(HtmlAttribute.CLASS, "border border-secondary rounded p-2");
			container.attribute(HtmlAttribute.ID, TagUtil.getId(this));

			if (!StringUtils.isEmpty(label)) {
				Div title = new Div();
				title.attribute(HtmlAttribute.CLASS, "text-center mb-3");
				H2 h2 = new H2();
				h2.attribute(HtmlAttribute.CLASS, "text-secondary");
				h2.add(TagUtil.getLocalized(label, getJspContext()));
				title.add(h2);
				container.add(title);
			}

			Div clearfix2 = new Div();
			clearfix2.attribute(HtmlAttribute.CLASS, "clearfix");
			container.add(clearfix2);

			if (!StringUtils.isEmpty(toolbar)) {
				Div divForToolbar = new Div();
				divForToolbar.attribute(HtmlAttribute.CLASS, "float-left m-2 button-group");
				divForToolbar.add(toolbar);
				clearfix2.add(divForToolbar);
			}

			if (!CollectionUtils.isEmpty(data)) {

				if (totalResults == null) {
					totalResults = data.size();
				}

				if (export) {
					Div divForExportation = new Div();
					divForExportation.attribute(HtmlAttribute.CLASS, "float-right m-2");

					Div buttonGroup = new Div();
					buttonGroup.attribute(HtmlAttribute.CLASS, "btn-group");

					Button pdf = new Button();
					pdf.attribute(HtmlAttribute.CLASS, "btn btn-outline-primary grid-export-pdf");
					pdf.attribute(HtmlAttribute.TITLE, TagUtil.getLocalizedForLib("grid.export.pdf", getJspContext()));
					pdf.add(new Span().attribute(HtmlAttribute.CLASS, "fa fa-file-pdf"));
					buttonGroup.add(pdf);

					Button excel = new Button();
					excel.attribute(HtmlAttribute.CLASS, "btn btn-outline-primary grid-export-excel");
					excel.attribute(HtmlAttribute.TITLE, TagUtil.getLocalizedForLib("grid.export.xls", getJspContext()));
					excel.add(new Span().attribute(HtmlAttribute.CLASS, "fa fa-file-excel"));
					buttonGroup.add(excel);

					Button csv = new Button();
					csv.attribute(HtmlAttribute.CLASS, "btn btn-outline-primary grid-export-csv");
					csv.attribute(HtmlAttribute.TITLE, TagUtil.getLocalizedForLib("grid.export.csv", getJspContext()));
					csv.add(new Span().attribute(HtmlAttribute.CLASS, "fa fa-file-csv"));
					buttonGroup.add(csv);

					Button xml = new Button();
					xml.attribute(HtmlAttribute.CLASS, "btn btn-outline-primary grid-export-xml");
					xml.attribute(HtmlAttribute.TITLE, TagUtil.getLocalizedForLib("grid.export.xml", getJspContext()));
					xml.add(new Span().attribute(HtmlAttribute.CLASS, "fa fa-file-code"));
					buttonGroup.add(xml);

					divForExportation.add(buttonGroup);
					clearfix2.add(divForExportation);
				}

				if (search) {
					Div divForSearch = new Div();
					divForSearch.attribute(HtmlAttribute.CLASS, "float-right m-5");
					Input input = new Input();
					input.attribute(HtmlAttribute.TYPE, "search");
					input.attribute(HtmlAttribute.CLASS, "grid-search form-control");
					input.attribute(HtmlAttribute.PLACEHOLDER, TagUtil.getLocalizedForLib("grid.search", getJspContext()));
					divForSearch.add(input);
					clearfix2.add(divForSearch);
				}

				Table table = new Table();
				table.attribute(HtmlAttribute.CLASS, "table table-striped table-hover table-light");

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
					clearfix.attribute(HtmlAttribute.CLASS, "clearfix");

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
					display.attribute(HtmlAttribute.CLASS, "float-left m-2");
					display.add(new H5().add(TagUtil.getLocalizedForLib("grid.page.viewing", getJspContext(),
							fromResult, toResult, totalResults)));
					clearfix.add(display);

					Integer totalOfPages = (int) Math
							.ceil(Double.valueOf(totalResults) / Double.valueOf(resultsPerPage));

					Div pagination = new Div();
					pagination.attribute(HtmlAttribute.CLASS, "float-right m-2");
					Nav nav = new Nav();
					nav.attribute(HtmlAttribute.CLASS, "float-left");
					Ul ul = new Ul();
					ul.attribute(HtmlAttribute.CLASS, "pagination");
					for (int i = 1; i <= totalOfPages; i++) {
						Li li = new Li();
						li.attribute(HtmlAttribute.CLASS, "page-item grid-paginate-item");
						if (i == page) {
							li.attribute(HtmlAttribute.CLASS, "active");
						}
						A a = new A();
						a.attribute(HtmlAttribute.HREF, "#");
						a.attribute(HtmlAttribute.CLASS, "page-link");
						a.add(String.valueOf(i));
						li.add(a);
						ul.add(li);
					}
					nav.add(ul);
					pagination.add(nav);
					clearfix.add(pagination);

					Div divForResultsPerPage = new Div();
					divForResultsPerPage.attribute(HtmlAttribute.CLASS, "float-right m-2");

					Div dropdown = new Div();
					dropdown.attribute(HtmlAttribute.CLASS, "dropdown dropup");
					dropdown.attribute(HtmlAttribute.TITLE, TagUtil.getLocalizedForLib("grid.results.per.page", getJspContext()));

					Button button = new Button();
					button.attribute(HtmlAttribute.CLASS, "btn btn-default dropdown-toggle");
					button.attribute(HtmlAttribute.DATA_TOGGLE, "dropdown");
					button.add(String.valueOf(resultsPerPage));

					dropdown.add(button);

					Div results = new Div();
					results.attribute(HtmlAttribute.CLASS, "dropdown-menu");
					Integer iteration = 100;
					while (iteration >= 20) {
						A a = new A();
						a.attribute(HtmlAttribute.HREF, "#");
						a.attribute(HtmlAttribute.CLASS, "dropdown-item grid-results-per-page-item");
						if (iteration == resultsPerPage) {
							a.attribute(HtmlAttribute.CLASS, "active");
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
				noRow.attribute(HtmlAttribute.CLASS, "alert alert-info");
				noRow.attribute(HtmlAttribute.ROLE, "alert");
				noRow.add((!StringUtils.isEmpty(noRowText) ? TagUtil.getLocalized(noRowText, getJspContext())
						: TagUtil.getLocalizedForLib("grid.no.row", getJspContext())));
				container.add(noRow);
			}

			if (export) {
				Div exporter = new Div();
				exporter.attribute(HtmlAttribute.CLASS, "hidden");
				Form form = new Form();
				form.attribute(HtmlAttribute.METHOD, "post");
				form.attribute(HtmlAttribute.TARGET, "_blank");
				form.attribute(HtmlAttribute.CLASS, "grid-export-form");
				form.attribute(HtmlAttribute.ACTION, TagUtil.getPathForUrl(getJspContext(), "/tagria-exporter"));
				Input type = new Input();
				type.attribute(HtmlAttribute.TYPE, "hidden");
				type.attribute(HtmlAttribute.NAME, "type");
				type.attribute(HtmlAttribute.CLASS, "grid-export-type");
				form.add(type);
				Input html = new Input();
				html.attribute(HtmlAttribute.TYPE, "hidden");
				html.attribute(HtmlAttribute.NAME, "json");
				html.attribute(HtmlAttribute.CLASS, "grid-export-json");
				form.add(html);
				exporter.add(form);
				container.add(exporter);
			}

			TagUtil.out(getJspContext(), container);
			TagUtil.appendJs("$('#" + container.attribute(HtmlAttribute.ID) + "').grid({ url : '"
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

	public List<HtmlTag> getThs() {
		return ths;
	}

	public void setThs(List<HtmlTag> ths) {
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
