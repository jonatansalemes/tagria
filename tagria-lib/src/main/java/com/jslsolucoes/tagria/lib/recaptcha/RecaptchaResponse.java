package com.jslsolucoes.tagria.lib.recaptcha;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class RecaptchaResponse {

    private Boolean success;
    private String hostname;

    @SerializedName("challenge_ts")
    private Date timestamp;

    public Boolean getSuccess() {
	return success;
    }

    public void setSuccess(Boolean success) {
	this.success = success;
    }

    public String getHostname() {
	return hostname;
    }

    public void setHostname(String hostname) {
	this.hostname = hostname;
    }

    public Date getTimestamp() {
	return timestamp;
    }

    public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
    }
}
