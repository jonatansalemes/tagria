package com.jslsolucoes.tagria.lib.tag.x;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HtmlUtil {

	private HtmlUtil() {

	}

	public static String urlEncode(String content) throws UnsupportedEncodingException {
		return URLEncoder.encode(content,"UTF-8");
	}
}
