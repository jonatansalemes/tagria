package com.jslsolucoes.tagria.formatter.v4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.cache.CacheInstance;
import com.jslsolucoes.cache.CacheInstanceBuilder;
import com.jslsolucoes.tagria.api.v4.Tagria;
import com.jslsolucoes.tagria.config.v4.ConfigurationParser;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;

public class DataFormatter {

    private CacheInstance<String,Object> cache = CacheInstanceBuilder.newBuilder().withKey(Tagria.CACHE_NAME).build();
    private List<Formatter> formatters;
    private static final Logger logger = LoggerFactory.getLogger(DataFormatter.class);

    @SuppressWarnings("unchecked")
    private DataFormatter() {
	formatters = cache.get("formatters", () -> formatters(),List.class);
    }

    public static DataFormatter newDataFormatter() {
	return new DataFormatter();
    }

    private List<Formatter> formatters() {
	return Stream.of(defaultFormatters(), customFormatters()).flatMap(list -> list.stream())
		.collect(Collectors.toList());
    }

    private List<Formatter> defaultFormatters() {
	return Arrays.asList(new CepFormatter(), new CnpjFormatter(), new CpfFormatter(), new CurrencyFormatter(),
		new DateTimeFormatter(), new PhoneFormatter(), new ZipCodeFormatter(), new DatePickerFormatter());
    }

    private List<Formatter> customFormatters() {
	List<Formatter> formatters = new ArrayList<>();
	List<com.jslsolucoes.tagria.config.v4.xml.Formatter> customFormatters = ConfigurationParser.newParser().parse()
		.getFormatters();
	if (!CollectionUtils.isEmpty(customFormatters)) {
	    for (com.jslsolucoes.tagria.config.v4.xml.Formatter customFormatter : customFormatters) {
		try {
		    formatters.add((Formatter) Class.forName(customFormatter.getClazz()).newInstance());
		} catch (Exception e) {
		    throw new TagriaRuntimeException(e);
		}
	    }
	} else {
	    logger.debug("Customs formatters not found on xml...");
	}
	return formatters;
    }

    public String format(String type, String value, Locale locale) {
	if (!StringUtils.isEmpty(value)) {
	    for (Formatter formatter : formatters) {
		if (formatter.accepts(type)) {

		    logger.debug(" type {} accepted by {}, value {}, locale {}", type, formatter, value, locale);
		    return formatter.format(type, value.trim(), locale);
		} else {
		    logger.debug(" type {} not accepted by {}", type, formatter);
		}
	    }
	}
	return value;
    }
}
