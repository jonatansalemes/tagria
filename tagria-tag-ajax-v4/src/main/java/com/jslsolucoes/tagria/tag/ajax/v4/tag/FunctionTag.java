
package com.jslsolucoes.tagria.tag.ajax.v4.tag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.tag.ajax.v4.FunctionParameter;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class FunctionTag extends AbstractSimpleTagSupport {

    private Boolean execute = Boolean.FALSE;
    private String dataType = "json";
    private String name;
    private String url;
    private String onBeforeSend;
    private String onDone;
    private String onError;
    private List<String> onSuccess = new ArrayList<String>();
    private List<FunctionParameter> data = new ArrayList<FunctionParameter>();

    @Override
    public void renderOnVoid() {

	String jsCode = "function " + name
		+ "(){var data = new Array();$.ajax({type:'post',processData:false,dataType:'" + dataType
		+ "',beforeSend: function(jqXHR, settings) {var data = {};for (var property in settings.data) {data[property] = settings.data[property].value;if(settings.data[property].required && settings.data[property].value == ''){return false;}}settings.data = $.param(data);"
		+ (!StringUtils.isEmpty(onBeforeSend) ? onBeforeSend : "") + "return true;},url: '" + pathForUrl(url)
		+ "',async:true,data: {"
		+ data.stream()
			.map(functionParameter -> "'" + functionParameter.getName() + "':{required:"
				+ functionParameter.getRequired() + ",value:" + functionParameter.getValue() + "}")
			.collect(Collectors.joining(","))
		+ "},error:function(jqXHR,textStatus,errorThrown){" + (!StringUtils.isEmpty(onError) ? onError : "")
		+ "},success:function(data,textStatus,jqXHR){" + onSuccess.stream().collect(Collectors.joining())
		+ "}}).done(function(){" + (!StringUtils.isEmpty(onDone) ? onDone : "") + "});}";
	appendJsCode(jsCode);
	if (execute) {
	    appendJsCode(name + "();");
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

    public String getOnBeforeSend() {
	return onBeforeSend;
    }

    public void setOnBeforeSend(String onBeforeSend) {
	this.onBeforeSend = onBeforeSend;
    }

}
