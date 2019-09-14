package com.jslsolucoes.tagria.tag.html.v4.tag.grid;

import java.util.Arrays;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
public class GridPaginateTag extends AbstractSimpleTagSupport {

	private Integer resultsPerPage = 60;
	private Integer totalResults;
	private Integer range = 4;

	@Override
	public void renderOnVoid() {
		findAncestorWithClass(GridTag.class).setPaginate(divPaginate());
	}

	private Element divPaginate() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "clearfix").add(divDisplay()).add(divNavigation())
				.add(divNavigationDropdown());
	}

	private Element divNavigationDropdown() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "float-right m-2").add(divDropdown());
	}

	private Element divDropdown() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "dropdown dropup")
				.attribute(Attribute.TITLE, keyForLibrary("grid.results.per.page")).add(buttonDropdown())
				.add(divDropdownMenu());
	}

	private Element divDropdownMenu() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "dropdown-menu");
		for (Integer resultsPerPage : Arrays.asList(20, 40, 60, 80, 100)) {
			div.add(aDropDown(resultsPerPage));
		}
		return div;
	}

	private Element aDropDown(Integer resultsPerPage) {
		Element a = ElementCreator.newA().attribute(Attribute.HREF, "#")
				.attribute(Attribute.CLASS, "dropdown-item grid-results-per-page-item").add(resultsPerPage.toString());
		if (resultsPerPage == this.resultsPerPage) {
			a.attribute(Attribute.CLASS, "active");
		}
		return a;
	}

	private Element buttonDropdown() {
		return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-default dropdown-toggle")
				.attribute(Attribute.DATA_TOGGLE, "dropdown").add(String.valueOf(resultsPerPage));
	}

	private Element divNavigation() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "float-right m-2").add(navPaginate());
	}

	private Element navPaginate() {
		return ElementCreator.newNav().attribute(Attribute.CLASS, "float-left").add(ulPaginate());
	}

	private Element ulPaginate() {
		
		Integer currentPage = currentPage();
		Integer totalOfPages = totalOfPages();
		
		Integer startOfPagination = currentPage - range;
		if(startOfPagination < 1) {
			startOfPagination = 1;
		}
		
		Integer endOfPagination = currentPage + range;
		if(endOfPagination > totalOfPages) {
			endOfPagination = totalOfPages;
		}
		
		Element ul = ElementCreator.newUl().attribute(Attribute.CLASS, "pagination");
		for (int i = startOfPagination; i <= totalOfPages(); i++) {
			ul.add(liPaginate(currentPage, i));
		}
		return ul;
	}

	private Element liPaginate(Integer currentPage, Integer page) {
		Element li = ElementCreator.newLi().attribute(Attribute.CLASS, "page-item grid-paginate-item")
				.add(aPaginate(page));
		if (currentPage == page) {
			li.attribute(Attribute.CLASS, "active");
		}
		return li;
	}

	private Element aPaginate(Integer page) {
		return ElementCreator.newA().attribute(Attribute.HREF, "#").attribute(Attribute.CLASS, "page-link")
				.add(page.toString());
	}

	private Integer totalOfPages() {
		return (int) Math.ceil(Double.valueOf(totalResults) / Double.valueOf(resultsPerPage));
	}

	private Element divDisplay() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "float-left m-2").add(h5Display());
	}

	private Element h5Display() {
		return ElementCreator.newH5()
				.add(keyForLibrary("grid.page.viewing", startOfResults(), endOfResults(), totalResults));
	}

	private Integer startOfResults() {
		Integer currentPage = currentPage();
		if (currentPage == 1) {
			return 1;
		} else {
			return ((currentPage - 1) * resultsPerPage()) + 1;
		}
	}

	private Integer endOfResults() {
		Integer endOfResults = currentPage() * resultsPerPage;
		if (endOfResults >= totalResults) {
			endOfResults = totalResults;
		}
		return endOfResults;
	}

	private Integer resultsPerPage() {
		return (httpServletRequest().getParameter("resultsPerPage") != null
				? Integer.valueOf(httpServletRequest().getParameter("resultsPerPage"))
				: this.resultsPerPage);
	}

	private Integer currentPage() {
		return (httpServletRequest().getParameter("page") != null
				? Integer.valueOf(httpServletRequest().getParameter("page"))
				: 1);
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

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}
}
