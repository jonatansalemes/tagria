
package com.jslsolucoes.tagria.lib.tag.html;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.html.Attribute;
import com.jslsolucoes.tagria.lib.html.Td;
import com.jslsolucoes.tagria.lib.tag.Formattabler;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class TableColumnTag extends SimpleTagSupport implements Formattabler {

	private String state = "default";
	private Integer colspan;
	private String label;
	private String formatType;
	private String formatMatch;
	private String formatReplace;

	@Override
	public void doTag() throws JspException, IOException {
		
		String body = TagUtil.getBody(getJspBody());
		Td td = new Td();
		td.add(Attribute.CLASS, "bg-" + state);
		if (colspan != null) {
			td.add(Attribute.COLSPAN, colspan);
		}
		if (!StringUtils.isEmpty(label)) {
			td.add(TagUtil.getLocalized(label, getJspContext()));
		} else {
			
			if (!StringUtils.isEmpty(formatType)) {
				body = TagUtil.format(formatType, formatMatch, formatReplace, body, getJspContext());
			}
			td.add(body);
		}
		TagUtil.out(getJspContext(), td);
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	@Override
	public void setFormatMatch(String formatMatch) {
		this.formatMatch = formatMatch;
	}

	@Override
	public void setFormatReplace(String formatReplace) {
		this.formatReplace = formatReplace;
	}

}
