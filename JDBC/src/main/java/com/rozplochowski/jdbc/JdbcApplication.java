package com.rozplochowski.jdbc;

import com.rozplochowski.jdbc.model.Exercise;
import com.rozplochowski.jdbc.model.TrainingLog;
import com.rozplochowski.jdbc.repository.ExerciseDao;
import com.rozplochowski.jdbc.repository.TrainingLogDao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JdbcApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(JdbcApplication.class);

    private final ExerciseDao exerciseDao;
    private final TrainingLogDao trainingLogDao;

    static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Exercise> exercises = exerciseDao.findAll();

        logger.info("Existing Exercises: {}", exercises);

        var running = exerciseDao.save(new Exercise("Running"));

        try {
            exerciseDao.save(new Exercise("Running"));
        } catch (DataAccessException ex) {
            var cause = (SQLException) ex.getCause();
            logger.error("Error code {}", cause.getErrorCode());
            logger.error("SQL state {}", cause.getSQLState());
        }

        logger.info("Saved Exercise: {}", running);

        var runningFromDb = exerciseDao.findById(running.getId());

        logger.info("Retrieved Exercise: {}", runningFromDb);

        runningFromDb.setName("Sprinting");
        exerciseDao.update(runningFromDb);

        logger.info("Exercises: {}", exerciseDao.findAll());

        var batch = List.of(
                new Exercise("Chin-Ups"),
                new Exercise("One-Arm Push-Ups"),
                new Exercise("Climbing")
        );

        exerciseDao.save(batch);

        logger.info("Exercises: {}", exerciseDao.findAll());

        logger.info("Exercises count is {}", exerciseDao.countAll());

        var trainingLog = new TrainingLog();
        trainingLog.setPerformedAt(Instant.now());
        trainingLog.setFinishedAt(Instant.now().plus(30, ChronoUnit.MINUTES));
        trainingLog = trainingLogDao.save(trainingLog);

        logger.info("Training log: {}", trainingLog);

        logger.info("Training log {}: {}", trainingLog.getId(), trainingLogDao.findById(trainingLog.getId()));

        trainingLogDao.delete(trainingLog);
    }
}
