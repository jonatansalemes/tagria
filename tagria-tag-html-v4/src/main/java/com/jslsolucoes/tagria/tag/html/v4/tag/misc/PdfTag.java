
package com.jslsolucoes.tagria.tag.html.v4.tag.misc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;
import com.jslsolucoes.tagria.html.v4.Span;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;

public class PdfTag extends AbstractSimpleTagSupport {

    private String attachToSelector;
    private String title;
    private String titleKey;
    private String filename = UUID.randomUUID().toString();
    private String filenameKey;
    private Boolean timestamp = Boolean.TRUE;
    private String pattern = "dd/MM/yyyy HH:mm:ss";

    @Override
    public Element render() {
	String id = id();
	Element div = div(id);
	appendJsCode("$('#" + id + "').pdf({selector:'" + attachToSelector + "',filename:'" + filename() + "'});");
	return div;
    }

    private String filename() {
	return normalize(keyOrLabel(filenameKey, filename)
		+ (timestamp ? "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)) : ""));
    }

    private Element div(String id) {
	return ElementCreator.newDiv().add(button(id));
    }

    private Element button(String id) {
	return ElementCreator.newButton().attribute(Attribute.ID, id).attribute(Attribute.CLASS, "btn btn-secondary")
		.attribute(Attribute.TITLE, title()).add(new Span().attribute(Attribute.CLASS, "fa fa-print"));
    }

    private String title() {
	return hasKeyOrLabel(titleKey, title) ? keyOrLabel(titleKey, title) : keyForLibrary("misc.print.pdf.page");
    }

    private String normalize(String fileName) {
	return StringUtils.stripAccents(fileName).replaceAll("( |\\/|:|!|\\.)", "_").toLowerCase();
    }

    public String getAttachToSelector() {
	return attachToSelector;
    }

    public void setAttachToSelector(String attachToSelector) {
	this.attachToSelector = attachToSelector;
    }

    public String getFilename() {
	return filename;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public Boolean getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(Boolean timestamp) {
	this.timestamp = timestamp;
    }

    public String getPattern() {
	return pattern;
    }

    public void setPattern(String pattern) {
	this.pattern = pattern;
    }

    public String getFilenameKey() {
	return filenameKey;
    }

    public void setFilenameKey(String filenameKey) {
	this.filenameKey = filenameKey;
    }

}
