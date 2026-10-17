package com.rozplochowski.jdbc;

import com.rozplochowski.jdbc.model.Exercise;
import com.rozplochowski.jdbc.repository.ExerciseDao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JdbcApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(JdbcApplication.class);

    private final ExerciseDao exerciseDao;

    static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Exercise> exercises = exerciseDao.findAll();

        logger.info("Existing Exercises: {}", exercises);

        var running = exerciseDao.save(new Exercise("Running"));

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
    }
}
