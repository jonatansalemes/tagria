package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.util.Collection;
import java.util.function.Consumer;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractIterableSimpleTagSupport extends AbstractSimpleTagSupport {

    private String var;
    private String varStatus;
    private Object data;
    private Object[] dataArray;
    private VarStatus varStatusObject;

    public void iterateOver(Consumer<Object> onNotEmpty) {
	iterateOver(onNotEmpty, () -> {});
    }

    public void iterateOver(Consumer<Object> onNotEmpty, NoArgsSupplier noArgsSupplier) {
	Collection<Object> objects = dataSet();
	if (!CollectionUtils.isEmpty(objects)) {
	    varStatusObject = new VarStatus();
	    for (Object object : objects) {
		setAttribute(var, object);
		if (!StringUtils.isEmpty(varStatus)) {
		    setAttribute(varStatus, varStatusObject);
		}
		onNotEmpty.accept(object);
		varStatusObject.increment();
	    }
	    setAttribute(var, null);
	    if (!StringUtils.isEmpty(varStatus)) {
		setAttribute(varStatus, null);
	    }
	} else {
	    noArgsSupplier.get();
	}
    }

    public Collection<Object> dataSet() {
	return dataSet(data, dataArray);
    }

    public Object getData() {
	return data;
    }

    public void setData(Object data) {
	this.data = data;
    }
    
    public Object[] getDataArray() {
	return dataArray;
    }

    public void setDataArray(Object[] dataArray) {
	this.dataArray = dataArray;
    }

    public String getVar() {
	return var;
    }

    public void setVar(String var) {
	this.var = var;
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

}
