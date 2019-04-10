
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Button;
import com.jslsolucoes.tagria.lib.html.Div;
import com.jslsolucoes.tagria.lib.html.Element;
import com.jslsolucoes.tagria.lib.html.H4;
import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.html.Span;
import com.jslsolucoes.tagria.lib.html.Textarea;
import com.jslsolucoes.tagria.lib.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;

@SuppressWarnings("rawtypes")
public class MultipleFormGroupTag extends SimpleTagSupport {

	private Collection data;
	private String var;
	private String label;
	private List<Element> ths = new ArrayList<>();
	private Integer atLeast = 0;
	private Boolean empty = Boolean.FALSE;
	private String afterInsert;

	@Override
	public void doTag() throws JspException, IOException {

		Div container = new Div();
		container.add(Attribute.ID, TagUtil.getId());
		container.add(Attribute.CLASS, "form-group border border-secondary rounded p-2 shadow-sm fg-container");
		
		Textarea template = new Textarea();
		template.add(Attribute.CLASS, "d-none fg-template");
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
		button.add(Attribute.CLASS, "btn btn-outline-primary fg-plus");
		button.add(new Span().add(Attribute.CLASS, "fas fa-plus"));
		toolbar.add(button);
		container.add(toolbar);

		Div content = new Div();
		content.add(Attribute.CLASS,"fg-content");
		if (!CollectionUtils.isEmpty(data)) {
			for (Object object : data) {
				getJspContext().setAttribute(var, object);
				content.add(formGroup(TagUtil.getBody(getJspBody())));
			}
			getJspContext().setAttribute(var, null);
		} else {
			for (int i = 0; i < (atLeast > 0 ? atLeast : 1); i++) {
				content.add(formGroup(TagUtil.getBody(getJspBody())));
			}
		}
		container.add(content);
		
		TagUtil.out(getJspContext(), container);
		Script script = new Script();
		script.add(Attribute.TYPE, "text/javascript");
		script.add("$('#" + container.get(Attribute.ID) + "').formGroup({ atLeast : " + atLeast + " , empty : " + empty
				+ ", afterInsert : function (element) { " + afterInsert + " } });");
		TagUtil.out(getJspContext(), script);

	}
	
	private Element formGroup(String content) {
		
		Div row = new Div();
		row.add(Attribute.CLASS,"row fg-row border rounded text-secondary mt-3 mb-3 p-3");
		
		Div col1 = new Div();
		col1.add(Attribute.CLASS,"col col-11");
		col1.add(new Div().add(content));
		
		Div col2 = new Div();
		col2.add(Attribute.CLASS,"col col-1 my-auto");
		col2.add(remove());
		
		row.add(col1);
		row.add(col2);
		
		return row;
	}
	
	private Element remove() {
		Button minus = new Button();
		minus.add(Attribute.ID, TagUtil.getId("fg.remove[]", null));
		minus.add(Attribute.CLASS, "btn btn-outline-danger fg-minus");
		minus.add(new Span().add(Attribute.CLASS, "fas fa-minus"));
		return minus;
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
