package com.jslsolucoes.tagria.tag.base.v4.tag;

import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.jslsolucoes.tagria.config.v4.xml.Warning;

public abstract class AbstractIterableSimpleTagSupport extends AbstractSimpleTagSupport {

    private static final Logger logger = LoggerFactory.getLogger(AbstractIterableSimpleTagSupport.class);
    private String var;
    private String varStatus;
    private Object data;
    private VarStatus varStatusObject = new VarStatus();

    public void iterateOver(Consumer<Object> onNotEmpty) {
	iterateOver(onNotEmpty, () -> {
	});
    }

    public void iterateOver(Consumer<Object> onNotEmpty, NoArgsSupplier noArgsSupplier) {
	Collection<Object> objects = dataSet();
	if (!CollectionUtils.isEmpty(objects)) {
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

    @SuppressWarnings("unchecked")
    public Collection<Object> dataSet() {
	Builder<Object> builder = ImmutableList.<Object>builder();
	Class<?> classOfDataset = data != null ? data.getClass() : Object.class;
	if (Collection.class.isAssignableFrom(classOfDataset)) {
	    Collection<Object> collection = (Collection<Object>) data;
	    if (!CollectionUtils.isEmpty(collection)) {
		builder.addAll(collection);
	    }
	} else if (Map.class.isAssignableFrom(classOfDataset)) {
	    Map<Object, Object> map = (Map<Object, Object>) data;
	    if (!MapUtils.isEmpty(map)) {
		map.entrySet().forEach(entry -> builder.add(entry));
	    }
	} else if (classOfDataset.isArray()) {
	    Object[] objects = (Object[]) data;
	    if (!ArrayUtils.isEmpty(objects)) {
		builder.add(objects);
	    }
	} else {
	    Object object = (Object) data;
	    if (object != null) {
		builder.add(object);
	    }
	}
	return checkForDataSetExceed(builder.build());
    }

    public Collection<Object> checkForDataSetExceed(Collection<Object> data) {
	Warning warning = xml().getWarning();
	Long componentDataSetThreshold = warning.getComponentDataSetThreshold();
	if (warning.getEnabled() && !CollectionUtils.isEmpty(data) && data.size() > componentDataSetThreshold) {
	    logger.warn("Component " + this + " exceeded data set size threshold => size {} items", data.size());
	}
	return data;
    }

    public Object getData() {
	return data;
    }

    public void setData(Object data) {
	this.data = data;
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
