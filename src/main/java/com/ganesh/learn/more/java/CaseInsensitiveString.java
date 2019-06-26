package com.ganesh.learn.more.java;

public class CaseInsensitiveString {

    private String s;

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(this.s);
    }
}
