package com.jslsolucoes.tagria.html;

import org.junit.Assert;
import org.junit.Test;

public class AbstractElementTest {

	@Test
	public void html() {
		Element element = ElementCreator.newInput().attribute(Attribute.NAME, "car");
		Assert.assertEquals("<input name=\"car\"/>", element.html());
	}

	@Test
	public void htmlChain() {
		Element element = ElementCreator.newInput().attribute(Attribute.NAME, "car")
				.attribute(Attribute.CLASS, "form-control").attribute(Attribute.CLASS, "required");
		Assert.assertEquals("<input name=\"car\" class=\"form-control required\"/>", element.html());
	}

	@Test
	public void docType() {
		Element element = ElementCreator.newDocTypeHtml5();
		Assert.assertEquals("<!DOCTYPE html>", element.html());
	}
}
