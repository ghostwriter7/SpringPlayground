package com.rozplochowski.jdbc.repository;

import com.rozplochowski.jdbc.model.TrainingLog;

public interface TrainingLogDao {

    TrainingLog save(TrainingLog trainingLog);

    TrainingLog findById(Long id);

    void delete(TrainingLog trainingLog);

}
