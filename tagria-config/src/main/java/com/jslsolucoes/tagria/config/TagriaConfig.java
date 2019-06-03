package com.jslsolucoes.tagria.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagriaConfig {

	private static final Logger logger = LoggerFactory.getLogger(TagriaConfig.class);

	private TagriaConfig() {

	}

	public static TagriaConfig newConfig() {
		return new TagriaConfig();
	}

	public String propertyValue(TagriaConfigParameter tagriaConfigParameter) {
		Properties properties = properties();
		if (properties == null) {
			return tagriaConfigParameter.getDefaultValue();
		} else {
			String value = (String) properties.get(tagriaConfigParameter.getName());
			if (value == null) {
				return tagriaConfigParameter.getDefaultValue();
			} else {
				return value;
			}
		}
	}

	private Properties properties() {
		try {
			Properties properties = new Properties();
			properties.load(TagriaConfig.class.getResourceAsStream("/tagrialib.properties"));
			return properties;
		} catch (Exception e) {
			logger.warn("Could not load tagrialib.properties", e);
			return null;
		}
	}
}
