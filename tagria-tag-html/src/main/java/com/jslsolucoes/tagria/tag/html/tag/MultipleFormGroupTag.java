
package com.jslsolucoes.tagria.tag.html.tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.jsp.JspContext;

import org.apache.commons.collections4.CollectionUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Button;
import com.jslsolucoes.tagria.html.Div;
import com.jslsolucoes.tagria.html.H4;
import com.jslsolucoes.tagria.html.Script;
import com.jslsolucoes.tagria.html.Span;
import com.jslsolucoes.tagria.html.TextArea;
import com.jslsolucoes.tagria.html.Th;
import com.jslsolucoes.tagria.lib.util.TagUtil;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.tagria.tag.html.VarStatus;

@SuppressWarnings("rawtypes")
public class MultipleFormGroupTag extends AbstractSimpleTagSupport {

	private Collection data;
	private String var;
	private String label;
	private List<HtmlTag> ths = new ArrayList<>();
	private Integer atLeast = 0;
	private Boolean empty = Boolean.FALSE;
	private String afterInsert;
	private String afterRemove;
	private String varStatus;
	private VarStatus varStatusObject;
	private Script script = new Script();

	@Override
	public void render() {

		varStatusObject = new VarStatus();
		Div container = new Div();
		container.attribute(Attribute.ID, TagUtil.getId(this));
		container.attribute(Attribute.CLASS, "form-group border border-secondary rounded p-2 shadow-sm fg-container");

		TextArea templateForScript = new TextArea();
		templateForScript.attribute(Attribute.CLASS, "d-none fg-template-script");
		templateForScript.add(script);
		container.add(templateForScript);

		TextArea template = new TextArea();
		template.attribute(Attribute.CLASS, "d-none fg-template");
		container.add(template);

		Div toolbar = new Div();
		toolbar.attribute(Attribute.CLASS, "p-2");

		Div buttonGroup = new Div();
		buttonGroup.attribute(Attribute.CLASS, "float-left clear-both");
		Button button = new Button();
		button.attribute(Attribute.TYPE, "button");
		button.attribute(Attribute.CLASS, "btn btn-outline-primary fg-plus");
		button.add(new Span().attribute(Attribute.CLASS, "fas fa-plus"));
		buttonGroup.add(button);
		toolbar.add(buttonGroup);

		if (!StringUtils.isEmpty(label)) {
			Div title = new Div();
			title.attribute(Attribute.CLASS, "text-center");
			H4 h4 = new H4();
			h4.attribute(Attribute.CLASS, "text-secondary");
			h4.add(TagUtil.getLocalized(getLabel(), getJspContext()));
			title.add(h4);
			toolbar.add(title);
		}

		container.add(toolbar);

		Div content = new Div();
		content.attribute(Attribute.CLASS, "fg-content");

		if (!CollectionUtils.isEmpty(data)) {

			JspContext jspContext = getJspContext();
			for (Object object : data) {
				jspContext.setAttribute(var, object);
				if (!StringUtils.isEmpty(varStatus)) {
					jspContext.setAttribute(varStatus, varStatusObject);
				}
				content.add(formGroup(TagUtil.getBody(getJspBody())));
				varStatusObject.increment();
			}
			if (!StringUtils.isEmpty(varStatus)) {
				jspContext.setAttribute(varStatus, null);
			}
			jspContext.setAttribute(var, null);
		} else {
			for (int i = 0; i < (atLeast > 0 ? atLeast : 1); i++) {
				content.add(formGroup(TagUtil.getBody(getJspBody())));
			}
		}
		container.add(content);

		TagUtil.out(getJspContext(), container);

		String afterInsertFunction = (!StringUtils.isEmpty(afterInsert) ? afterInsert + "(idx,element);" : "");
		String afterRemoveFunction = (!StringUtils.isEmpty(afterRemove) ? afterRemove + "();" : "");
		TagUtil.appendJs("$('#" + container.attribute(Attribute.ID) + "').formGroup({atLeast:" + atLeast + ",empty:"
				+ empty + ",afterInsert:function(idx,element){" + afterInsertFunction + " },afterRemove:function(){"
				+ afterRemoveFunction + "}});", this);

	}

	private HtmlTag formGroup(String content) {

		Div row = new Div();
		row.attribute(Attribute.CLASS, "row fg-row border rounded text-secondary mt-3 mb-3 p-3");

		Div col1 = new Div();
		col1.attribute(Attribute.CLASS, "col col-11");
		col1.add(new Div().add(content));

		Div col2 = new Div();
		col2.attribute(Attribute.CLASS, "col col-1 my-auto");
		col2.add(remove());

		row.add(col1);
		row.add(col2);

		return row;
	}

	private HtmlTag remove() {
		Button minus = new Button();
		minus.attribute(Attribute.ID, TagUtil.getId(this));
		minus.attribute(Attribute.CLASS, "btn btn-outline-danger fg-minus");
		minus.add(new Span().attribute(Attribute.CLASS, "fas fa-minus"));
		return minus;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<HtmlTag> getThs() {
		return ths;
	}

	public void setThs(List<HtmlTag> ths) {
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

	public String getVarStatus() {
		return varStatus;
	}

	public void setVarStatus(String varStatus) {
		this.varStatus = varStatus;
	}

	public VarStatus getVarStatusObject() {
		return varStatusObject;
	}

	public void setVarStatusObject(VarStatus varStatusObject) {
		this.varStatusObject = varStatusObject;
	}

	public String getAfterRemove() {
		return afterRemove;
	}

	public void setAfterRemove(String afterRemove) {
		this.afterRemove = afterRemove;
	}

	public Script getScript() {
		return script;
	}

	public void setScript(Script script) {
		this.script = script;
	}

}
