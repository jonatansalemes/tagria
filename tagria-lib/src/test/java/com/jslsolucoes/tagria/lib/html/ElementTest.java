package com.jslsolucoes.tagria.lib.html;

import org.junit.Assert;
import org.junit.Test;



public class ElementTest {

	@Test
	public void html(){
		Element element = new Input();
		element.add(Attribute.NAME,"zezinho");
		
		Assert.assertEquals("<input name=\"zezinho\"/>", element.getHtml());
	}
}
