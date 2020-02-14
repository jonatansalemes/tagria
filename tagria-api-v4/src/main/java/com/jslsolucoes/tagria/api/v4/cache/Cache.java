package com.jslsolucoes.tagria.api.v4.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cache {

    private static Logger logger = LoggerFactory.getLogger(Cache.class);
    private static Cache cacheInstance;
    private Map<String, Object> cache = new ConcurrentHashMap<>();

    public Cache remove(String key) {
	logger.debug("Removing key {} from cache", key);
	cache.remove(key);
	return this;
    }

    public Cache clear() {
	logger.debug("Clearing cache");
	cache.clear();
	return this;
    }

    public Cache put(String key, Object value) {
	logger.debug("Putting on cache {}={}.", key, value);
	cache.put(key, value);
	return this;
    }

    @SuppressWarnings("unchecked")
    public <R> R get(String key, Supplier<R> defaultValue, Class<R> clazz) {
	Object value = cache.get(key);
	if (value == null) {
	    logger.debug("Key {} was not found on cache.", key);
	    put(key, value = defaultValue.get());
	} else {
	    logger.debug("Key {} was retrieved from cache with value {}.", key, value);
	}
	return (R) value;
    }

    public static Cache instance() {
	if (cacheInstance == null) {
	    logger.debug("Initializing new cache ...");
	    cacheInstance = new Cache();
	}
	return cacheInstance;
    }
}
