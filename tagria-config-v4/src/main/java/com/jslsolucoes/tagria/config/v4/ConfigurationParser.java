package com.jslsolucoes.tagria.config.v4;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.api.v4.cache.Cache;
import com.jslsolucoes.tagria.config.v4.xml.Configuration;

public class ConfigurationParser {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationParser.class);
    private static Cache cache = Cache.instance();

    private ConfigurationParser() {

    }

    public static ConfigurationParser newParser() {
	return cache.get("configurationParser", new ConfigurationParser(), ConfigurationParser.class);
    }

    public Configuration parse() {
	return cache.get("configuration", createInstance(), Configuration.class);
    }

    private Configuration createInstance() {
	try {
	    InputStream props = ConfigurationParser.class.getResourceAsStream("/tagrialib.xml");
	    JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
	    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	    return ((Configuration) unmarshaller.unmarshal(props));
	} catch (Exception e) {
	    logger.warn("Could not load or parse Tagria xml config, creating default one ...", e);
	    return new Configuration();
	}
    }

}
