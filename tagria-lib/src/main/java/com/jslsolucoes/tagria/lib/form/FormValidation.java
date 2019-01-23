package com.jslsolucoes.tagria.lib.form;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.jslsolucoes.tagria.lib.html.Li;
import com.jslsolucoes.tagria.lib.html.Ul;

public class FormValidation {

	private FormValidation() {

	}

	public static FormValidation newBuilder() {
		return new FormValidation();
	}

	public String toUnordenedList(List<String> items) {
		if (!CollectionUtils.isEmpty(items)) {
			Ul ul = new Ul();
			for (String item : items) {
				Li li = new Li();
				li.add(item);
				ul.add(li);
			}
			return ul.getHtml();
		}
		return "";
	}
}
