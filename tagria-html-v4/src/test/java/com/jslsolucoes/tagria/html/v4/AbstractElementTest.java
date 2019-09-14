package com.jslsolucoes.tagria.html.v4;

import org.junit.Assert;
import org.junit.Test;

import com.jslsolucoes.tagria.html.v4.Attribute;
import com.jslsolucoes.tagria.html.v4.Element;
import com.jslsolucoes.tagria.html.v4.ElementCreator;

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
		Assert.assertEquals("<input class=\"form-control required\" name=\"car\"/>", element.html());
	}

	@Test
	public void docType() {
		Element element = ElementCreator.newDocTypeHtml5();
		Assert.assertEquals("<!DOCTYPE html>", element.html());
	}
}
