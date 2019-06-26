package com.ganesh.learn.more.java;

import java.util.HashMap;

public class ParametrizedMethod {

    public static <K,V> HashMap<K,V> newInstance() {
        return new HashMap<K,V>();
    }
}
