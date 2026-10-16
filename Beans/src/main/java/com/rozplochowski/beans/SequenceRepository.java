package com.rozplochowski.beans;

import org.springframework.stereotype.Repository;

@Repository
class SequenceRepository {

    private final Sequence sequence;

    public SequenceRepository(final Sequence sequence) {
        this.sequence = sequence;
    }

    String next() {
        return sequence.next();
    }
}
