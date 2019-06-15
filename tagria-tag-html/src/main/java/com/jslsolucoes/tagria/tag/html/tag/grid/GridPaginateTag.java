package com.jslsolucoes.tagria.tag.html.tag.grid;

import javax.servlet.http.HttpServletRequest;

import com.jslsolucoes.tagria.html.A;
import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.H5;
import com.jslsolucoes.tagria.html.Li;
import com.jslsolucoes.tagria.html.Nav;
import com.jslsolucoes.tagria.html.Ul;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class GridPaginateTag extends AbstractSimpleTagSupport {

	private Integer resultsPerPage = 60;
	private Integer totalResults;

	@Override
	public void renderOnVoid() {

		Div clearfix = new Div();
		clearfix.attribute(Attribute.CLASS, "clearfix");

		HttpServletRequest request = httpServletRequest();
		Integer page = (request.getParameter("page") != null ? Integer.valueOf(request.getParameter("page")) : 1);
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

		findAncestorWithClass(GridTag.class).setPaginate(clearfix);
	}

	public Integer getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
}
