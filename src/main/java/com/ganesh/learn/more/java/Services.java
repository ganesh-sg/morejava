package com.ganesh.learn.more.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();
    private static final String DEFAULT_PROVIDER_NAME = "some";

    public static void registerProvider(Provider provider) {
        registerProvider(provider, DEFAULT_PROVIDER_NAME);
    }

    public static void registerProvider(Provider provider, String name) {
        providers.put(name, provider);
    }

    public static Provider newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Provider newInstance(String name) {
        Provider provider = providers.get(name);
        if (provider == null) {
            throw new IllegalArgumentException("No provider exists with the name " + name);
        }
        return provider;
    }
}
