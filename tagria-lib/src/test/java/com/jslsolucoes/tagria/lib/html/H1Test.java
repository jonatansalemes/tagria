package com.jslsolucoes.tagria.lib.html;

import org.junit.Assert;
import org.junit.Test;

public class H1Test {

	@Test
	public void testHtml(){
		H1 h1 = new H1();
		Assert.assertEquals("<h1/>",h1.getHtml());
	}
}
