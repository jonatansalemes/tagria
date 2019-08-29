package com.jslsolucoes.tagria.config.v4;

import java.io.InputStream;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.config.v4.xml.TagriaXML;

public class TagriaConfig {

	private static final Logger logger = LoggerFactory.getLogger(TagriaConfig.class);

	private TagriaConfig() {

	}

	public static TagriaConfig newConfig() {
		return new TagriaConfig();
	}

	public TagriaXML xml() {
		try {
			InputStream props = TagriaConfig.class.getResourceAsStream("/tagrialib.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(TagriaXML.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return ((TagriaXML) unmarshaller.unmarshal(props));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
