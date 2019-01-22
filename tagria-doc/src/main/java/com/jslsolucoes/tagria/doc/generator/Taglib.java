
package com.jslsolucoes.tagria.doc.generator;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("taglib")
@XmlRootElement
public class Taglib {
	private String description;

	@XStreamAlias("display-name")
	private String displayName;

	@XStreamAlias("tlib-version")
	private String tlibVersion;

	@XStreamAlias("short-name")
	private String shortName;

	private String uri;

	@XStreamImplicit
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
