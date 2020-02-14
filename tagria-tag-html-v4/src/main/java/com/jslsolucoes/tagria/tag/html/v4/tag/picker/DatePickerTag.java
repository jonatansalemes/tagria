package com.jslsolucoes.tagria.tag.html.v4.tag.picker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class DatePickerTag extends AbstractSimpleTagSupport {

    private String attachTo;
    private String attachToSelector;
    private Integer min;
    private Integer max;
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void renderOnVoid() {
	String selector = attachTo(attachToSelector, attachTo);
	appendJsCode("$('" + selector + "').attr('type','date');");
	if (min != null) {
	    appendJsCode("$('" + selector + "').attr('min','" + LocalDate.now().minusDays(min).format(dateTimeFormatter)
		    + "');");
	}
	if (max != null) {
	    appendJsCode("$('" + selector + "').attr('max','" + LocalDate.now().plusDays(max).format(dateTimeFormatter)
		    + "');");
	}
    }

    public String getAttachTo() {
	return attachTo;
    }

    public void setAttachTo(String attachTo) {
	this.attachTo = attachTo;
    }

    public String getAttachToSelector() {
	return attachToSelector;
    }

    public void setAttachToSelector(String attachToSelector) {
	this.attachToSelector = attachToSelector;
    }

    public Integer getMin() {
	return min;
    }

    public void setMin(Integer min) {
	this.min = min;
    }

    public Integer getMax() {
	return max;
    }

    public void setMax(Integer max) {
	this.max = max;
    }

}
