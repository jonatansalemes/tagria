package com.jslsolucoes.tagria.html;

import org.junit.Assert;
import org.junit.Test;

import com.jslsolucoes.tagria.html.HtmlAttribute;
import com.jslsolucoes.tagria.html.HtmlFactory;
import com.jslsolucoes.tagria.html.Input;

public class InputTest {

	@Test
	public void html() {
		Input input = (Input) HtmlFactory.newInput().attribute(HtmlAttribute.NAME, "car");
		Assert.assertEquals("<input name=\"car\"/>", input.html());
	}

	@Test
	public void htmlChain() {
		Input input = (Input) HtmlFactory.newInput().attribute(HtmlAttribute.NAME, "car").attribute(HtmlAttribute.CLASS, "form-control").attribute(HtmlAttribute.CLASS,
				"required");
		Assert.assertEquals("<input name=\"car\" class=\"form-control required\"/>", input.html());
	}
}
