
package com.jslsolucoes.tagria.tag.ajax.v4.tag;

import java.io.IOException;
import java.io.StringWriter;

import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.tag.base.v4.tag.AbstractSimpleTagSupport;
import com.jslsolucoes.template.TemplateBuilder;

public class MapOptionsTag extends AbstractSimpleTagSupport {
	private String target;
	private String text;
	private String value;

	@Override
	public void renderOnVoid() {
		try (StringWriter stringWriter = new StringWriter()) {
			TemplateBuilder.newBuilder().withClasspathTemplate("template-ajax-tag", "mapOptions.tpl")
					.withData("id", idForName(target)).withData("tokens", text.split(",")).withData("value", value)
					.withOutput(stringWriter).process();
			findAncestorWithClass(FunctionTag.class).addOnSuccess(stringWriter.toString());
		} catch (IOException e) {
			throw new TagriaRuntimeException(e);
		}
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
