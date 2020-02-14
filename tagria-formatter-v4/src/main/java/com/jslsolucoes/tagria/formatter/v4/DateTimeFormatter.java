package com.jslsolucoes.tagria.formatter.v4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeFormatter implements Formatter {

    private static final Logger logger = LoggerFactory.getLogger(DateTimeFormatter.class);

    @Override
    public String format(String type, String value, Locale locale) {
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
	patterns.add("MMM dd, yyyy hh:mm:ss a");

	for (String cpattern : patterns) {
	    try {
		logger.debug("pattern {} match with value {}, formatting ...", cpattern, value);
		return dateFormat.format(new SimpleDateFormat(cpattern, Locale.ENGLISH).parse(value));
	    } catch (ParseException pe) {
		logger.debug("pattern {} does not match with value {}", cpattern, value);
	    }
	}
	return value;
    }

    @Override
    public Boolean accepts(String type) {
	return "timestamp".equals(type) || "datetime".equals(type) || "date".equals(type) || "hour".equals(type);
    }

}
