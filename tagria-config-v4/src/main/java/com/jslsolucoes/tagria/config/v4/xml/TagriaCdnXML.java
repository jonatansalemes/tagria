package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cdn")
@XmlAccessorType(XmlAccessType.FIELD)
public class TagriaCdnXML {

    private Boolean enabled = Boolean.FALSE;
    
    private String url;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
