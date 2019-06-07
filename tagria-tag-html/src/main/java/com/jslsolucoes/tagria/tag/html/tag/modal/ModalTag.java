
package com.jslsolucoes.tagria.tag.html.tag.modal;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ModalTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private String attachTo;
	private String attachToSelector;
	private Boolean closeable = Boolean.TRUE;
	private Boolean centered = Boolean.FALSE;
	private Boolean open = Boolean.FALSE;
	private Element toolbar;
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

		if (open != null && open) {
			appendJsCode("$('#" + div.attribute(Attribute.ID) + "').modal('show')");
		}
		return div;
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
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-content").add(divModalHeader())
				.add(divModalBody());
		if (toolbar != null) {
			div.add(divModalFooter());
		}
		return div;
	}

	private Element divModalFooter() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-footer").add(toolbar);
	}

	private Element divModalHeader() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-header").add(h4());
		if (closeable) {
			div.add(button());
		}
		return div;
	}

	private Element button() {
		return ElementCreator.newButton().attribute(Attribute.CLASS, "close").attribute(Attribute.DATA_DISMISS, "modal")
				.add(span());
	}

	private Element span() {
		return ElementCreator.newSpan().add("&times;");
	}

	private Element h4() {
		return ElementCreator.newH4().attribute(Attribute.CLASS, "modal-title").add(keyOrLabel(labelKey, label));
	}

	private Element divModalBody() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-body").add(bodyContent());
	}

	public void setToolbar(Element toolbar) {
		this.toolbar = toolbar;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}