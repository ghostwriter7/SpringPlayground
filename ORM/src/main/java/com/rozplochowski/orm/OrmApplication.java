package com.rozplochowski.orm;

import com.rozplochowski.orm.domain.Course;
import com.rozplochowski.orm.repository.CourseDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class OrmApplication implements CommandLineRunner {
    private final CourseDao courseDao;

    static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var courses = courseDao.findAll();
        log.info("Courses: {}", courses);

        var newCourse = new Course();
        newCourse.setTitle("New Course");
        newCourse.setFee(1000);
        newCourse.setBeginDate(LocalDate.now());
        newCourse.setEndDate(LocalDate.now().plusDays(10));

        newCourse = courseDao.store(newCourse);

        log.info("Courses: {}", courseDao.findAll());

        newCourse.setTitle("Updated Course");
        courseDao.store(newCourse);

        log.info("Courses: {}", courseDao.findAll());

        courseDao.delete(newCourse.getId());

        log.info("Courses: {}", courseDao.findAll());
    }
}
