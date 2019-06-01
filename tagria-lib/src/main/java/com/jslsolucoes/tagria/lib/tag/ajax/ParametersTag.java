
package com.jslsolucoes.tagria.lib.tag.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.jslsolucoes.tagria.lib.util.TagUtil;

public class ParametersTag extends SimpleTagSupport {

	private List<String> parameters = new ArrayList<String>();

	public ParametersTag() {
		addParameter("ajax", true, "true");
	}

	@Override
	public void doTag() throws JspException, IOException {
		TagUtil.getBody(getJspBody());
		FunctionTag functionTag = (FunctionTag) findAncestorWithClass(this, FunctionTag.class);
		functionTag.setParameters(StringUtils.join(parameters, ","));
	}

	public void addParameter(String name, Boolean required, String value) {
		this.parameters.add("'" + name + "' : { required : " + required + ", value : " + value + " }");
	}

}
