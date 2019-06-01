package com.jslsolucoes.tagria.tag.x;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class XTagTest {

	@Test
	public void concat() {
		Assert.assertEquals("ab", XTag.concat("a", "b"));
	}

	@Test
	public void join() {
		List<String> letters = Arrays.asList("a", "b", "c");
		Assert.assertEquals("a-b-c", XTag.join(letters, "-"));
	}

	@Test
	public void length() {
		Assert.assertEquals(Integer.valueOf(4), XTag.length(Long.valueOf(1034)));
	}

	@Test
	public void lineBreak() {
		Assert.assertEquals("teste<br>teste", XTag.lineBreak("teste\nteste"));
	}

	@Test
	public void stackTrace() {
		Exception exception = new Exception("Test");
		Assert.assertTrue(!XTag.fullStackTrace(exception).contains("\n"));
	}

	@Test
	public void stackTraceWithBr() {
		Exception exception = new Exception("Test");
		Assert.assertTrue(XTag.fullStackTrace(exception).contains("<br/>"));
	}
}
