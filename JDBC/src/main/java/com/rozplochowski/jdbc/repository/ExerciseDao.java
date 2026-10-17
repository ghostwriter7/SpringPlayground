package com.rozplochowski.jdbc.repository;

import com.rozplochowski.jdbc.model.Exercise;

import java.util.List;

public interface ExerciseDao {

    List<Exercise> findAll();

    Exercise findById(Long id);

    void update(Exercise exercise);

    Exercise save(Exercise exercise);

    List<Exercise> save(List<Exercise> exercises);

    int countAll();
}
