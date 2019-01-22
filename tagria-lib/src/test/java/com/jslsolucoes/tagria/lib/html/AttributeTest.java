package com.jslsolucoes.tagria.lib.html;

import org.junit.Assert;
import org.junit.Test;



public class AttributeTest {

	
	@Test
	public void attributes(){
		for(Attribute attribute : Attribute.values()){
			Assert.assertEquals(attribute.name().toLowerCase().replaceAll("_","-"), attribute.getName());
		}
	}
}
