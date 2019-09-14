package com.jslsolucoes.tagria.exporter.v4.parser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jslsolucoes.tagria.exception.v4.TagriaRuntimeException;
import com.jslsolucoes.tagria.exporter.v4.parser.model.Table;

public class TableParser {

	private String json;

	public static TableParser newParser() {
		return new TableParser();
	}

	public TableParser withJson(String json) {
		this.json = json;
		return this;
	}

	public Table parse() {
		try {
			ObjectMapper objectMapper = objectMapper();
			return objectMapper.readValue(json, Table.class);
		} catch (Exception e) {
			throw new TagriaRuntimeException(e);
		}
	}

	private ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}
}
