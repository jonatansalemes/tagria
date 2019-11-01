package com.jslsolucoes.tagria.formatter.v4;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatePickerFormatter implements Formatter {

    private static final Logger logger = LoggerFactory.getLogger(DatePickerFormatter.class);

    @Override
    public String format(String type, String value, Locale locale) {
	List<String> patterns = new ArrayList<>();
	patterns.add("yyyy-MM-dd'T'HH:mm:ss");
	patterns.add("yyyy-MM-dd HH:mm:ss");
	patterns.add("yyyy-MM-dd");
	patterns.add("E MMM dd HH:mm:ss zzz yyyy");
	patterns.add("MMM dd, yyyy hh:mm:ss a");
	for (String cpattern : patterns) {
	    try {
		logger.debug("pattern {} match with value {}, formatting ...", cpattern, value);
		return DateTimeFormatter.ofPattern("yyyy-MM-dd")
			.format(DateTimeFormatter.ofPattern(cpattern, Locale.ENGLISH).parse(value));
	    } catch (DateTimeParseException pe) {
		logger.debug("pattern {} does not match with value {}", cpattern, value);
	    }
	}
	return value;
    }

    @Override
    public Boolean accepts(String type) {
	return "datePicker".equals(type);
    }

}
