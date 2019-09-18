package com.jslsolucoes.tagria.formatter.v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.jslsolucoes.tagria.config.v4.TagriaConfig;
import com.jslsolucoes.tagria.config.v4.xml.TagriaFormatterXML;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;

public class DataFormatter {

    private List<Formatter> formatters;

    private DataFormatter() {
	formatters = formatters();
    }

    public static DataFormatter newInstance() {
	return new DataFormatter();
    }

    private List<Formatter> formatters() {
	return Stream.of(defaultFormatters(), customFormatters()).flatMap(list -> list.stream())
		.collect(Collectors.toList());
    }

    private List<Formatter> defaultFormatters() {
	return Arrays.asList(new CepFormatter(), new CnpjFormatter(), new CpfFormatter(), new CurrencyFormatter(),
		new DateTimeFormatter(), new PhoneFormatter(), new ZipCodeFormatter());
    }

    private List<Formatter> customFormatters() {
	List<Formatter> formatters = new ArrayList<>();
	List<TagriaFormatterXML> customTagriaFormatters = TagriaConfig.newConfig().xml().getFormatters();
	if (!CollectionUtils.isEmpty(customTagriaFormatters)) {
	    for (TagriaFormatterXML tagriaFormatterXML : customTagriaFormatters) {
		try {
		    formatters.add((Formatter) Class.forName(tagriaFormatterXML.getClazz()).newInstance());
		} catch (Exception e) {
		    throw new TagriaRuntimeException(e);
		}
	    }
	}
	return formatters;
    }

    public String format(String type, String value, Locale locale) {
	if (StringUtils.isEmpty(value)) {
	    return value;
	} else {
	    for (Formatter formatter : formatters) {
		if (formatter.accepts(type)) {
		    return formatter.format(type, value, locale);
		}
	    }
	}
	return value;
    }
}
