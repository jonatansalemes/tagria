package com.jslsolucoes.tagria.lib.tag.x;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void concat(){
		Assert.assertEquals("ab",StringUtil.concat("a", "b"));
	}
	
	@Test
	public void join(){
		List<String> letters = Arrays.asList("a","b","c");
		Assert.assertEquals("a-b-c",StringUtil.join(letters, "-"));
	}
	
	@Test
	public void length(){
		Assert.assertEquals(Integer.valueOf(4),StringUtil.length(Long.valueOf(1034)));
	}
	
	@Test
	public void lineBreak(){
		Assert.assertEquals("teste<br>teste",StringUtil.lineBreak("teste\nteste"));
	}
	
	@Test
	public void stackTrace(){
		Exception exception = new Exception("Test");
		Assert.assertTrue(!StringUtil.fullStackTrace(exception).contains("\n"));
	}
	
	@Test
	public void stackTraceWithBr(){
		Exception exception = new Exception("Test");
		Assert.assertTrue(StringUtil.fullStackTrace(exception).contains("<br/>"));
	}
}
