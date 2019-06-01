package com.jslsolucoes.tagria.lib.html;

import org.junit.Assert;
import org.junit.Test;

public class InputTest {

	@Test
	public void html() {
		Input input = (Input) HtmlFactory.newInput().attribute(Attribute.NAME, "car");
		Assert.assertEquals("<input name=\"car\"/>", input.html());
	}

	@Test
	public void htmlChain() {
		Input input = (Input) HtmlFactory.newInput().attribute(Attribute.NAME, "car").attribute(Attribute.CLASS, "form-control").attribute(Attribute.CLASS,
				"required");
		Assert.assertEquals("<input name=\"car\" class=\"form-control required\"/>", input.html());
	}
}
