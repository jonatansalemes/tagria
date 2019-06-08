package com.jslsolucoes.tagria.tag.base.tag;

import java.util.List;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jslsolucoes.tagria.html.Element;

public class CacheService {

	private static final Cache<String, List<Element>> cache = CacheBuilder.newBuilder().build();

	public static List<Element> get(String key) {
		return cache.getIfPresent(key);
	}

	public static List<Element> put(String key, List<Element> elements) {
		cache.put(key, elements);
		return elements;
	}

}
