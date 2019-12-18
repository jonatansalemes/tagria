
package com.jslsolucoes.tagria.doc.v4.generator;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "taglib")
@XmlAccessorType(XmlAccessType.FIELD)
public class Taglib {
    private String description;

    @XmlElement(name = "display-name")
    private String displayName;

    @XmlElement(name = "tlib-version")
    private String tlibVersion;

    @XmlElement(name = "short-name")
    private String shortName;

    private String uri;

    @XmlElement(name = "tag")
    private List<Tag> tags;

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDisplayName() {
	return displayName;
    }

    public void setDisplayName(String displayName) {
	this.displayName = displayName;
    }

    public String getTlibVersion() {
	return tlibVersion;
    }

    public void setTlibVersion(String tlibVersion) {
	this.tlibVersion = tlibVersion;
    }

    public String getShortName() {
	return shortName;
    }

    public void setShortName(String shortName) {
	this.shortName = shortName;
    }

    public String getUri() {
	return uri;
    }

    public void setUri(String uri) {
	this.uri = uri;
    }

    public List<Tag> getTags() {
	return tags;
    }

    public void setTags(List<Tag> tags) {
	this.tags = tags;
    }

}
