package com.jslsolucoes.tagria.api.v4;

import com.jslsolucoes.cache.CacheInstance;
import com.jslsolucoes.cache.CacheInstanceBuilder;

public class Tagria {

    private static final String VERSION = "4.0.32.0";
    private static final CacheInstance<String, Object> CACHE = CacheInstanceBuilder.newBuilder().withKey("tagriaCache")
	    .build();
    
    private Tagria() {
	
    }

    public static final CacheInstance<String, Object> cache() {
	return CACHE;
    }

    public static final String version() {
	return VERSION;
    }
}
