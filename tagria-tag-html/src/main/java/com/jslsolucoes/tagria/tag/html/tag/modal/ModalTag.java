
package com.jslsolucoes.tagria.tag.html.tag.modal;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ModalTag extends AbstractSimpleTagSupport {

	private String attachTo;
	private String attachToSelector;
	private Boolean closeable = Boolean.TRUE;
	private Boolean centered = Boolean.FALSE;
	private Boolean open = Boolean.FALSE;
	private String size;

	@Override
	public Element render() {
		return div();
	}

	private Element div() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal fade")
				.attribute(Attribute.ID, idForId(id)).add(divDialog());
		if (!closeable) {
			div.attribute(Attribute.DATA_KEYBOARD, "false");
			div.attribute(Attribute.DATA_BACKDROP, "static");
		}
		appendJsCode("$('" + attachTo(attachToSelector, attachTo)
				+ "').attr('data-toggle','modal').attr('data-target','#" + div.attribute(Attribute.ID) + "');");

		if (open()) {
			appendJsCode("$('#" + div.attribute(Attribute.ID) + "').modal('show')");
		}
		return div;
	}

	private Boolean open() {
		return open != null && open;
	}

	private Element divDialog() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-dialog").add(divModalContent());
		if (!StringUtils.isEmpty(size)) {
			div.attribute(Attribute.CLASS, "modal-" + size);
		}
		if (centered) {
			div.attribute(Attribute.CLASS, "modal-dialog-centered");
		}
		return div;
	}

	private Element divModalContent() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-content").add(bodyContent());
	}

	public String getAttachTo() {
		return attachTo;
	}

	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}

	public Boolean getCloseable() {
		return closeable;
	}

	public void setCloseable(Boolean closeable) {
		this.closeable = closeable;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public String getAttachToSelector() {
		return attachToSelector;
	}

	public void setAttachToSelector(String attachToSelector) {
		this.attachToSelector = attachToSelector;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getCentered() {
		return centered;
	}

	public void setCentered(Boolean centered) {
		this.centered = centered;
	}

}