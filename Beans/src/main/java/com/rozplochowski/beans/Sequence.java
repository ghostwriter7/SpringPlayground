package com.rozplochowski.beans;

import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {
    private final AtomicInteger counter = new AtomicInteger();
    private final String prefix;
    private final String suffix;

    public Sequence(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String next() {
        return prefix + counter.incrementAndGet() + suffix;
    }
}
