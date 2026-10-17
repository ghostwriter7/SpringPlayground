package com.rozplochowski.jdbc;

import com.rozplochowski.jdbc.model.Exercise;
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

    private final JdbcTemplate jdbcTemplate;

    static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Exercise> exercises = jdbcTemplate.query("select id, name from exercise", (rs, rowNumber) -> {
            var name = rs.getString("name");
            var id = rs.getLong("id");
            var exercise = new Exercise();
            exercise.setName(name);
            exercise.setId(id);
            return exercise;
        });

        logger.info("Exercises: {}", exercises);
    }
}
