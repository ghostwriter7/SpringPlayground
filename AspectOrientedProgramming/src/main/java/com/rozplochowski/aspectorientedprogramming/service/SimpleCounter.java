package com.rozplochowski.aspectorientedprogramming.service;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter implements Counter {
    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public int getValue() {
        return counter.get();
    }
}
