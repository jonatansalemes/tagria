package com.jslsolucoes.tagria.exporter.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jslsolucoes.tagria.exporter.parser.model.Table;

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
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, Table.class);
	}
}
