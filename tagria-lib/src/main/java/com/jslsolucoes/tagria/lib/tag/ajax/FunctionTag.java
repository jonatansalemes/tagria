
package com.jslsolucoes.tagria.lib.tag.ajax;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jslsolucoes.tagria.lib.html.Script;
import com.jslsolucoes.tagria.lib.util.TagUtil;

public class FunctionTag extends SimpleTagSupport {

	private Boolean executeOnDocumentLoad = Boolean.FALSE;
	private String dataType = "json";
	private String name;
	private String url;
	private Boolean rendered = Boolean.TRUE;
	private String preCode = "";
	private String beforeSend = "";
	private String onDone = "";
	private String onError = "";
	private String onSuccess = "";
	private String parameters = "";
	
	@Override
	public void doTag() throws JspException, IOException {
		if (rendered != null && rendered) {
			TagUtil.getBody(getJspBody());										
			String ajaxFunction = "function " + name + "(){"
								+ 		preCode
								+ "		var data = new Array();																		"
								+ "		$.ajax({																					"
								+ "			type : 'post',																			"
								+ "			processData: false,																		"
								+ "			dataType : '" + dataType + "',															"
								+ "			beforeSend: function(jqXHR, settings) {													"
								+ "				var data = {};																		"
								+ "				for (var property in settings.data) {												"
								+ "					data[property] = settings.data[property].value;									"
								+ "    				if(settings.data[property].required && settings.data[property].value == ''){	"
								+ "    					return false;																"
								+ "    				}																				"
								+ "				}																					"
								+ "				settings.data = $.param(data);														"
								+   			beforeSend 
								+ "				return true;																		"
								+ "			},																						"
								+ "			url : '" + TagUtil.getPathForUrl(getJspContext(), url)+ "',								"
								+ "			async: true,																			"
								+ "			data : { 																				"
								+				parameters
								+ "			},																						"
								+ "			error : function (jqXHR, textStatus, errorThrown) {										"
								+				onError
								+ "			},																						"
								+ "			success : function(data, textStatus, jqXHR) {											"
								+				onSuccess
								+ "			}																						"
								+ "		}).done(function() {																		" 
								+ 			onDone
								+ "		});																							"
								+ "}";

			Script function = new Script();
			function.add(ajaxFunction);

			TagUtil.out(getJspContext(), function);

			if (executeOnDocumentLoad) {
				Script script = new Script();
				script.add(name + "();");
				TagUtil.out(getJspContext(), script);
			}
		}

	}

	public Boolean getExecuteOnDocumentLoad() {
		return executeOnDocumentLoad;
	}

	public void setExecuteOnDocumentLoad(Boolean executeOnDocumentLoad) {
		this.executeOnDocumentLoad = executeOnDocumentLoad;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getRendered() {
		return rendered;
	}

	public void setRendered(Boolean rendered) {
		this.rendered = rendered;
	}

	public String getPreCode() {
		return preCode;
	}

	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}

	public String getBeforeSend() {
		return beforeSend;
	}

	public void setBeforeSend(String beforeSend) {
		this.beforeSend = beforeSend;
	}

	public String getOnDone() {
		return onDone;
	}

	public void setOnDone(String onDone) {
		this.onDone = onDone;
	}

	public String getOnError() {
		return onError;
	}

	public void setOnError(String onError) {
		this.onError = onError;
	}

	public String getOnSuccess() {
		return onSuccess;
	}

	public void setOnSuccess(String onSuccess) {
		this.onSuccess = onSuccess;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}
