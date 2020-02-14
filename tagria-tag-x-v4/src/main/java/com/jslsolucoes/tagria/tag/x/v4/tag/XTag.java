
package com.jslsolucoes.tagria.tag.x.v4.tag;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import com.jslsolucoes.tagria.formatter.v4.DataFormatter;

public class XTag {

    private XTag() {

    }

    public static String urlEncode(String content) throws UnsupportedEncodingException {
	return URLEncoder.encode(content, "UTF-8");
    }

    public static Boolean equals(String value1, String value2) {
	return value1.equals(value2);
    }

    public static String join(Collection<?> collection, String separator) {
	return StringUtils.join(collection, separator);
    }

    public static String concat(String value1, String value2) {
	return concatenation(value1, value2);
    }

    public static String concat(String value1, String value2, String value3) {
	return concatenation(value1, value2, value3);
    }

    public static String concat(String value1, String value2, String value3, String value4) {
	return concatenation(value1, value2, value3, value4);
    }

    public static String concat(String value1, String value2, String value3, String value4, String value5) {
	return concatenation(value1, value2, value3, value4, value5);
    }

    private static String concatenation(String... values) {
	return Arrays.asList(values).stream().collect(Collectors.joining());
    }

    public static Integer length(Long value) {
	return String.valueOf(value).length();
    }

    public static String fullStackTrace(Exception exception) {
	return ExceptionUtils.getStackTrace(exception).replaceAll("\n", "<br/>");
    }

    public static String lineBreak(String value) {
	return value.replaceAll("\n", "<br>");
    }

    public static String format(String type, Object value) {
	return format(type, value.toString(), Locale.getDefault());
    }

    public static String format(String type, String value, Locale locale) {
	return DataFormatter.newDataFormatter().format(type, value, locale);
    }

    public static String truncate(String value, Integer size) {
	if (size > value.length()) {
	    return value;
	} else {
	    return value.substring(0, size).concat("...");
	}
    }

}