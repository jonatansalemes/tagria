package com.jslsolucoes.tagria.api.v4;

import com.jslsolucoes.tagria.api.v4.cache.MemoryCache;
import com.jslsolucoes.tagria.api.v4.cache.MemoryCacheBuilder;

public class Tagria {

    private static final String VERSION = "4.0.36.0";
    private static final MemoryCache<String, Object> CACHE = MemoryCacheBuilder.newBuilder().withKey("tagriaCache")
	    .build();
    
    private Tagria() {
	
    }

    public static final MemoryCache<String, Object> cache() {
	return CACHE;
    }

    public static final String version() {
	return VERSION;
    }
}
