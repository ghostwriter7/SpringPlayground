package com.rozplochowski.jdbc.repository;

import com.rozplochowski.jdbc.model.Exercise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Repository
@RequiredArgsConstructor
@Slf4j
public class IsolationLevelDemoRepository {
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;

    public void readUncommitted() throws InterruptedException {
        var t1 = new Thread(() -> {
            var name = Thread.currentThread().getName();

            var def = new DefaultTransactionDefinition();
            var status = transactionManager.getTransaction(def);

            try {
                log.info("Thread {} updates exercise", name);
                jdbcTemplate.update("update exercise set name = 'dummyname' where id = 1");
                sleep(2);
                throw new RuntimeException("That was dummy after all..");
            } catch (RuntimeException ex) {
                log.info("Thread {} rollbacks", name);
                transactionManager.rollback(status);
                throw ex;
            }
        });

        t1.start();

        var t2 = new Thread(() -> {
            var name = Thread.currentThread().getName();

            var def = new DefaultTransactionDefinition();
            def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);

            var status = transactionManager.getTransaction(def);

            try {
                sleep(2);
                var exercise = jdbcTemplate.queryForObject("SELECT id, name FROM exercise WHERE id = 1", (rs, rowNumber) ->
                        new Exercise(rs.getString("name"), rs.getLong("id")));

                log.info("Thread {} reads exercise {}", name, exercise);
            } catch (RuntimeException ex) {
                transactionManager.rollback(status);
                throw ex;
            }
        });

        t2.start();

        t1.join();
        t2.join();
    }

    public void readCommitted() throws InterruptedException {
        var t1 = new Thread(() -> {
            var name = Thread.currentThread().getName();

            var def = new DefaultTransactionDefinition();
            var status = transactionManager.getTransaction(def);

            try {
                log.info("Thread {} updates exercise", name);
                jdbcTemplate.update("update exercise set name = 'dummyname' where id = 1");
                sleep(2);
                log.info("Thread {} commits now", name);
            } catch (RuntimeException ex) {
                log.info("Thread {} rollbacks", name);
                transactionManager.rollback(status);
                throw ex;
            }
        });

        t1.start();

        var t2 = new Thread(() -> {
            var name = Thread.currentThread().getName();

            var def = new DefaultTransactionDefinition();
            def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

            var status = transactionManager.getTransaction(def);

            try {
                sleep(1);
                var exercise = jdbcTemplate.queryForObject("SELECT id, name FROM exercise WHERE id = 1", (rs, rowNumber) ->
                        new Exercise(rs.getString("name"), rs.getLong("id")));

                log.info("Thread {} reads exercise {} (before T1 commits)", name, exercise);
            } catch (RuntimeException ex) {
                transactionManager.rollback(status);
                throw ex;
            }
        });

        t2.start();

        t1.join();
        t2.join();
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
    }
}

