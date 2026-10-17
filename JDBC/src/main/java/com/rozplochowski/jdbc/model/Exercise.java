package com.rozplochowski.jdbc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exercise {
    private String name;
    private Long id;

    public Exercise() {}

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Exercise(String name) {
        this.name = name;
    }

    public Exercise(String name, Long id) {
        this.name = name;
        this.id = id;
    }
}
