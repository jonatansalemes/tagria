package com.jslsolucoes.tagria.lib.auth;

public interface Auth {
	public Boolean allowed(String uri, String method);
}
