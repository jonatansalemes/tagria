
package com.jslsolucoes.tagria.tag.ajax.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.jslsolucoes.tagria.exception.TagriaRuntimeException;
import com.jslsolucoes.tagria.tag.ajax.FunctionParameter;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.template.TemplateBuilder;

public class FunctionTag extends AbstractSimpleTagSupport {

	private Boolean execute = Boolean.FALSE;
	private String dataType = "json";
	private String name;
	private String url;
	private String beforeSend;
	private String onDone;
	private String onError;
	private List<String> onSuccess = new ArrayList<String>();
	private List<FunctionParameter> data = new ArrayList<FunctionParameter>();

	@Override
	public void renderOnVoid() {
		try (StringWriter stringWriter = new StringWriter()) {
			TemplateBuilder.newBuilder().withClasspathTemplate("template-ajax-tag", "function.tpl")
					.withData("name", name).withData("url", pathForUrl(url)).withData("dataType", dataType)
					.withData("data", data).withData("onSuccess", onSuccess).withData("onDone", onDone)
					.withData("onError", onError)
					.withData("beforeSend",beforeSend)
					.withOutput(stringWriter).process();
			appendJsCode(stringWriter.toString());
			if (execute) {
				appendJsCode(name + "();");
			}
		} catch (IOException e) {
			throw new TagriaRuntimeException(e);
		}
	}
	
	@Override
	public Boolean flush() {
		return true;
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

	public List<FunctionParameter> getData() {
		return data;
	}

	public void setData(List<FunctionParameter> data) {
		this.data = data;
	}

	public void addFunctionParameter(FunctionParameter functionParameter) {
		this.data.add(functionParameter);
	}

	public void addOnSuccess(String jsCode) {
		this.onSuccess.add(jsCode);
	}

	public Boolean getExecute() {
		return execute;
	}

	public void setExecute(Boolean execute) {
		this.execute = execute;
	}

	public List<String> getOnSuccess() {
		return onSuccess;
	}

	public void setOnSuccess(List<String> onSuccess) {
		this.onSuccess = onSuccess;
	}

}
