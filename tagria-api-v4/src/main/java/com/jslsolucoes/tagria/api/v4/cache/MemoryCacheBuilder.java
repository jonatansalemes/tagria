package com.jslsolucoes.tagria.api.v4.cache;

import java.util.concurrent.Callable;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@SuppressWarnings("unchecked")
public class MemoryCacheBuilder<K, V> {

    private String key;
    private Cache<K, V> cache = CacheBuilder.newBuilder().concurrencyLevel(200).build();
    private static Cache<Object, Object> cacheOfCaches = CacheBuilder.newBuilder().build();

    public static MemoryCacheBuilder<Object, Object> newBuilder() {
	return new MemoryCacheBuilder<>();
    }

    public MemoryCacheBuilder<K, V> withKey(String key) {
	this.key = key;
	return this;
    }

    public MemoryCacheBuilder<K, V> withCache(Cache<K, V> cache) {
	this.cache = cache;
	return this;
    }

    public <K1 extends K, V1 extends V> MemoryCache<K1, V1> build() {
	Preconditions.checkNotNull(key, "Key must be provided for cache name");
	try {
	    return (MemoryCache<K1, V1>) cacheOfCaches.get(key, new Callable<MemoryCache<K1, V1>>() {
		@Override
		public MemoryCache<K1, V1> call() throws Exception {
		    return new MemoryCache<K1, V1>((Cache<K1, V1>) cache);
		}
	    });
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
}
