package com.jslsolucoes.tagria.tag.html.tag.misc;

import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.html.Attribute;
import com.jslsolucoes.tagria.html.Element;
import com.jslsolucoes.tagria.html.ElementCreator;
import com.jslsolucoes.tagria.tag.base.tag.AbstractSimpleTagSupport;

public class ConfirmDialogTag extends AbstractSimpleTagSupport {

	private String label;
	private String labelKey;
	private String url = "#";
	private String target = "_self";
	private String attachTo;
	private String attachToSelector;

	@Override
	public Element render() {
		Element modal = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal fade").attribute(Attribute.ID, id())
				.add(divModalDialog());
		appendJsCode("$('" + attachTo(attachToSelector, attachTo) + "').attr('data-toggle','modal').attr('data-target','#" + modal.attribute(Attribute.ID) + "');");
		return modal;
	}

	private Element divModalDialog() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-dialog modal-sm").add(divModalContent());
	}

	private Element divModalContent() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-content").add(divModalHeader())
				.add(divModalBody()).add(divModalFooter());
	}

	private Element divModalFooter() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-footer").add(buttonCancel()).add(aSure());
	}

	private Element divModalBody() {
		Element div = ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-body");
		String bodyContent = bodyContent();
		if (!StringUtils.isEmpty(bodyContent)) {
			div.add(bodyContent);
		} else if (!hasKeyOrLabel(labelKey, label)) {
			div.add(keyForLibrary("confirm.text"));
		} else {
			div.add(keyOrLabel(labelKey, label));
		}
		return div;
	}

	private Element divModalHeader() {
		return ElementCreator.newDiv().attribute(Attribute.CLASS, "modal-header").add(h4ModalTitle())
				.add(buttonClose());
	}

	private Element h4ModalTitle() {
		return ElementCreator.newH4().attribute(Attribute.CLASS, "modal-title").add(keyForLibrary("confirm.title"));
	}

	private Element buttonClose() {
		return ElementCreator.newButton().attribute(Attribute.CLASS, "close").attribute(Attribute.DATA_DISMISS, "modal")
				.add(spanTimes());
	}

	private Element spanTimes() {
		return ElementCreator.newSpan().add("&times;");
	}

	private Element buttonCancel() {
		return ElementCreator.newButton().attribute(Attribute.CLASS, "btn btn-outline-danger cancel")
				.attribute(Attribute.DATA_DISMISS, "modal").add(keyForLibrary("confirm.cancel"));
	}

	private Element aSure() {
		return ElementCreator.newA().attribute(Attribute.CLASS, "btn btn-outline-primary sure")
				.add(keyForLibrary("confirm.ok")).attribute(Attribute.HREF, pathForUrl(url))
				.attribute(Attribute.TARGET, target);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
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

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

}
