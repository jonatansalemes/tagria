
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Table;
import com.jslsolucoes.tagria.lib.html.Tbody;
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.html.Textarea;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.html.Thead;
import com.jslsolucoes.tagria.lib.html.Tr;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("rawtypes")
public class DetailTableTag extends SimpleTagSupport {

	private Collection data;
	private String var;
	private String label;
	private List<Element> ths = new ArrayList<>();
	private String iteration = RandomStringUtils.randomAlphanumeric(20);
	private Integer atLeast = 0;
	private Boolean empty = Boolean.FALSE;
	private String afterInsert;

	@Override
	public void doTag() throws JspException, IOException {

		String body = TagUtil.getBody(getJspBody());

		Div container = new Div();
		container.add(Attribute.ID, TagUtil.getId());
		
		Textarea template = new Textarea();
		template.add(Attribute.CLASS, "d-none detail-table-template");
		container.add(template);
		
		if (!StringUtils.isEmpty(label)) {
			Div title = new Div();
			title.add(Attribute.CLASS, "text-center");
			H4 h4 = new H4();
			h4.add(Attribute.CLASS, "text-secondary");
			h4.add(TagUtil.getLocalized(getLabel(), getJspContext()));
			title.add(h4);
			container.add(title);
		}

		Div toolbar = new Div();
		toolbar.add(Attribute.CLASS, "p-2");
		Button button = new Button();
		button.add(Attribute.TYPE, "button");
		button.add(Attribute.CLASS, "btn btn-outline-primary detail-table-plus");
		button.add(new Span().add(Attribute.CLASS, "fas fa-plus"));
		toolbar.add(button);
		container.add(toolbar);

		Table table = new Table();
		table.add(Attribute.CLASS, "table table-striped table-hover detail-table-table");

		Th th = new Th();
		this.ths.add(th);

		Thead thead = new Thead();
		Tr tr = new Tr();
		thead.add(tr);
		tr.add(this.ths);
		table.add(thead);

		Tbody tbody = new Tbody();

		if (!CollectionUtils.isEmpty(data)) {
			for (Object row : data) {
				getJspContext().setAttribute(var, row);
				Tr line = new Tr();
				line.add(TagUtil.getBody(getJspBody()));
				line.add(remove());
				tbody.add(line);
				iteration = RandomStringUtils.randomAlphanumeric(20);
			}
			getJspContext().setAttribute(var, null);
		} else {
			for (int i = 0; i < (atLeast > 0 ? atLeast : 1); i++) {
				Tr line = new Tr();
				line.add(body);
				line.add(remove());
				tbody.add(line);
				iteration = RandomStringUtils.randomAlphanumeric(20);
			}
		}

		table.add(tbody);

		container.add(table);

		TagUtil.out(getJspContext(), container);

		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + container.get(Attribute.ID) + "').detail({ atLeast : " + atLeast + " , empty : " + empty
				+ ", afterInsert : function (tr) { " + afterInsert + " } });");
		TagUtil.out(getJspContext(), script);

	}

	private Element remove() {
		Td td = new Td();
		td.add(Attribute.CLASS,"detail-table-minus-column");
		Button minus = new Button();
		minus.add(Attribute.ID, TagUtil.getId("bs.detail.table.remove[]", null));
		minus.add(Attribute.CLASS, "btn btn-outline-danger detail-table-minus");
		minus.add(new Span().add(Attribute.CLASS, "fas fa-minus"));
		td.add(minus);
		return td;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Element> getThs() {
		return ths;
	}

	public void setThs(List<Element> ths) {
		this.ths = ths;
	}

	public void add(Th th) {
		ths.add(th);
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

	public String getIteration() {
		return iteration;
	}

	public void setIteration(String iteration) {
		this.iteration = iteration;
	}

	public Integer getAtLeast() {
		return atLeast;
	}

	public void setAtLeast(Integer atLeast) {
		this.atLeast = atLeast;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}

	public String getAfterInsert() {
		return afterInsert;
	}

	public void setAfterInsert(String afterInsert) {
		this.afterInsert = afterInsert;
	}

}
