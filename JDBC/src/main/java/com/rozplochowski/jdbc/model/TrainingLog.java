package com.rozplochowski.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingLog {

    private Long id;
    private Instant performedAt;
    private Instant finishedAt;

    @Override
    public String toString() {
        return """
                id: %d
                performedAt: %s
                finishedAt: %s
                """.formatted(id, performedAt, finishedAt);
    }
}
