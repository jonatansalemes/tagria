
package com.jslsolucoes.tagria.tag.x;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class XTag {

	private XTag() {

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
		return format(type, null, null, value.toString(), Locale.getDefault());
	}

	public static String format(String type, String match, String replace, String value, Locale locale) {
		if (StringUtils.isEmpty(value)) {
			return value;
		} else if ("date".equals(type) || "datetime".equals(type) || "timestamp".equals(type) || "hour".equals(type)) {

			DateFormat dateFormat = DateFormat.getDateTimeInstance();
			if ("timestamp".equals(type) || "datetime".equals(type)) {
				dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale);
			} else if ("date".equals(type)) {
				dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
			} else if ("hour".equals(type)) {
				dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
			}
			List<String> patterns = new ArrayList<>();
			patterns.add("yyyy-MM-dd'T'HH:mm:ss");
			patterns.add("yyyy-MM-dd HH:mm:ss");
			patterns.add("yyyy-MM-dd");
			patterns.add("E MMM dd HH:mm:ss zzz yyyy");
			for (String cpattern : patterns) {
				try {
					return dateFormat.format(new SimpleDateFormat(cpattern, Locale.ENGLISH).parse(value));
				} catch (ParseException pe) {
					// Try another format
				}
			}
			return value;
		} else if ("currency".equals(type)) {
			DecimalFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(locale));
			return nf.format(new Double(value));
		} else if ("cep".equals(type)) {
			return String.format("%08d", Long.valueOf(value)).replaceAll("^([0-9]{5})([0-9]{3})$", "$1-$2");
		} else if ("cpf".equals(type)) {
			return String.format("%011d", Long.valueOf(value)).replaceAll("^([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})$",
					"$1.$2.$3-$4");
		} else if ("cnpj".equals(type)) {
			return String.format("%014d", Long.valueOf(value))
					.replaceAll("^([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$", "$1.$2.$3/$4-$5");
		} else if ("tel".equals(type)) {
			return String.format("%010d", Long.valueOf(value)).replaceAll("^([0-9]{2})([0-9]{4,5})([0-9]{4})$",
					"($1) $2-$3");
		} else if ("zipCode".equals(type)) {
			return String.format("%08d", Long.valueOf(value)).replaceAll("^([0-9]{5})-([0-9]{3})$", "$1-$2");
		} else if ("custom".equals(type)) {
			return value.replaceAll(match, replace);
		}
		return value;
	}

	public static String truncate(String value, Integer size) {
		if (size > value.length()) {
			return value;
		} else {
			return value.substring(0, size).concat("...");
		}
	}

}