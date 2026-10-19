package com.rozplochowski.jdbc.repository;

import com.rozplochowski.jdbc.model.Exercise;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.*;
import java.util.List;

@Repository
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ExerciseDaoImpl implements ExerciseDao {
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;
    private final TransactionTemplate transactionTemplate;

    //    private final RowMapper<Exercise> exerciseRowMapper = (ResultSet rs, int rowNum) -> {
//        var name = rs.getString("name");
//        var id = rs.getLong("id");
//        return new Exercise(name, id);
//    };
    private final RowMapper<Exercise> exerciseRowMapper = BeanPropertyRowMapper.newInstance(Exercise.class);

    @Override
    public void txDemo() {
        var def = new DefaultTransactionDefinition();
        var status = transactionManager.getTransaction(def);
        try {
            var keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(pps -> {
                var ps = pps.prepareStatement("insert into exercise (name) values (?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "test");
                return ps;
            }, keyHolder);
            var id = keyHolder.getKey().longValue();
            jdbcTemplate.update("update exercise set name = ? where id = ?", "test2", id);

            var exercise = jdbcTemplate.queryForObject("select id, name from exercise where id = ?", exerciseRowMapper, id);

            transactionManager.commit(status);
        } catch (RuntimeException ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }

    @Override
    public void txDemoWithTemplate() {
        var result = transactionTemplate.execute(action -> {
            jdbcTemplate.update("insert into exercise (name) values (?)", "Swimming");
            return jdbcTemplate.queryForObject("select id from exercise where name = ?", Long.class, "Swimming");
        });
        IO.println("txDemoWithTemplate result: %s".formatted(result));
    }

    @Override
    public int countAll() {
        return jdbcTemplate.queryForObject("select count(*) from exercise", Integer.class);
    }

    @Override
    public List<Exercise> findAll() {
        return jdbcTemplate.query("select id, name from exercise", exerciseRowMapper);
    }

    @Override
    public Exercise findById(Long id) {
//        var exercise = new Exercise();
//        jdbcTemplate.query(pss -> {
//            var ps = pss.prepareStatement("select * from exercise where id = ?");
//            ps.setLong(1, id);
//            return ps;
//        }, rs -> {
//            exercise.setName(rs.getString("name"));
//            exercise.setId(rs.getLong("id"));
//        });

        return jdbcTemplate.queryForObject("select * from exercise where id = ?", exerciseRowMapper, id);
    }

    @Override
    public Exercise save(Exercise exercise) {
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc -> {
            var ps = psc.prepareStatement("insert into exercise (name) values (?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, exercise.getName());
            return ps;
        }, keyHolder);
        var id = keyHolder.getKey().longValue();
        return new Exercise(exercise.getName(), id);
    }

    @Override
    public List<Exercise> save(List<Exercise> exercises) {
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.batchUpdate((Connection conn) -> conn.prepareStatement("insert into exercise (name) values (?)", Statement.RETURN_GENERATED_KEYS),
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        var exercise = exercises.get(i);
                        ps.setString(1, exercise.getName());
                    }

                    @Override
                    public int getBatchSize() {
                        return exercises.size();
                    }
                }, keyHolder);

        var keys = keyHolder.getKeyList();
        for (var i = 0; i < exercises.size(); i++) {
            Long id = (Long) keys.get(i).get("ID");
            exercises.get(i).setId(id);
        }

        return exercises;
    }

    @Override
    public void update(Exercise exercise) {
        jdbcTemplate.update("update exercise set name = ? where id = ?", pss -> {
            pss.setString(1, exercise.getName());
            pss.setLong(2, exercise.getId());
        });

//        jdbcTemplate.update("update exercise set name = ? where id = ?", exercise.getName(), exercise.getId());
    }
}
