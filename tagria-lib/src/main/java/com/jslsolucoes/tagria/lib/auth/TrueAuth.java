package com.jslsolucoes.tagria.lib.auth;

public class TrueAuth implements Auth {

	@Override
	public Boolean allowed(String uri, String method) {
		return true;
	}

}
