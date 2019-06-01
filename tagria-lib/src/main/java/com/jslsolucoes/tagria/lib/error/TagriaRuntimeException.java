package com.jslsolucoes.tagria.lib.error;

@SuppressWarnings("serial")
public class TagriaRuntimeException extends RuntimeException {

	public TagriaRuntimeException(Exception exception) {
		super(exception);
	}

	public TagriaRuntimeException(String message) {
		super(message);
	}
}