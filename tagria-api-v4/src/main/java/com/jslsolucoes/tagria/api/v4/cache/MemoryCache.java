package com.jslsolucoes.tagria.api.v4.cache;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class MemoryCache<K, V> {

    private final static Logger logger = LoggerFactory.getLogger(MemoryCache.class);
    private final Cache<K, V> cache;

    MemoryCache(Cache<K, V> cache2) {
	this.cache = cache2;
    }

    public MemoryCache<K, V> remove(K key) {
	logger.debug("Removing key {} from CacheInstance", key);
	cache.invalidate(key);
	return this;
    }

    public MemoryCache<K, V> clear() {
	logger.debug("Clearing cache");
	cache.invalidateAll();
	return this;
    }

    public MemoryCache<K, V> put(K key, V value) {
	logger.debug("Creating entry on cache {}={}.", key, value);
	cache.put(key, value);
	return this;
    }

    public <T> T get(K key, Class<T> clazz) {
	return (T) get(key, () -> null, clazz);
    }

    public <T> T get(K key, Supplier<V> defaultValue, Class<T> clazz) {
	return (T) get(key, defaultValue);
    }

    public V get(K key) {
	return get(cache, key, () -> null);
    }

    public V get(K key, Supplier<V> defaultValue) {
	return get(cache, key, defaultValue);
    }

    private V get(Cache cache, K key, Supplier<V> supplier) {
	logger.debug("Querying cache for key {}", key);
	V object = (V) cache.getIfPresent(key);
	if (object == null) {
	    logger.debug("Cache miss, key {} was not found on cache", key);
	    V value = supplier.get();
	    if (value != null) {
		put(key, object = value);
	    } else {
		logger.debug("Value was ignored on cache because is null");
	    }
	} else {
	    logger.debug("Cache hit for key {}", key);
	}
	return object;
    }
}
