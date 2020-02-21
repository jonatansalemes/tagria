package com.jslsolucoes.tagria.config.v4.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "warning")
@XmlAccessorType(XmlAccessType.FIELD)
public class Warning {

    private Boolean enabled = Boolean.FALSE;
    private Long componentMountTimeThreshold = 1200L;
    private Long componentDataSetThreshold = 300L;

    public Long getComponentMountTimeThreshold() {
	return componentMountTimeThreshold;
    }

    public void setComponentMountTimeThreshold(Long componentMountTimeThreshold) {
	this.componentMountTimeThreshold = componentMountTimeThreshold;
    }

    public Long getComponentDataSetThreshold() {
	return componentDataSetThreshold;
    }

    public void setComponentDataSetThreshold(Long componentDataSetThreshold) {
	this.componentDataSetThreshold = componentDataSetThreshold;
    }

    public Boolean getEnabled() {
	return enabled;
    }

    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }

}
