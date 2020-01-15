package com.jslsolucoes.tagria.config.v4;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jslsolucoes.tagria.config.v4.xml.TagriaXML;

public class TagriaConfig {

    private static final Logger logger = LoggerFactory.getLogger(TagriaConfig.class);
    private static TagriaXML xml;
    public static final String VERSION = "4.0.15.0";

    private TagriaConfig() {

    }

    public static TagriaConfig newConfig() {
	return new TagriaConfig();
    }

    public TagriaXML xml() {
	if (xml == null) {
	    logger.debug("Loading config for the first time..");
	    try {
		InputStream props = TagriaConfig.class.getResourceAsStream("/tagrialib.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(TagriaXML.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		xml = ((TagriaXML) unmarshaller.unmarshal(props));
	    } catch (Exception e) {
		logger.warn("Could not load or parse Tagria xml config, creating default one ...", e);
		xml = new TagriaXML();
	    }
	}
	return xml;
    }

}
