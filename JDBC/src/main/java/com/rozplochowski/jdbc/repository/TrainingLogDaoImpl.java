package com.rozplochowski.jdbc.repository;

import com.rozplochowski.jdbc.model.TrainingLog;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TrainingLogDaoImpl implements TrainingLogDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public TrainingLog save(TrainingLog trainingLog) {
        Map<String, Instant> params = Map.of(
                "performedAt", trainingLog.getPerformedAt(),
                "finishedAt", trainingLog.getFinishedAt()
        );
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("insert into training_log (performed_at, finished_at) values (:performedAt, :finishedAt)",
                new MapSqlParameterSource(params), keyHolder);

        var id = keyHolder.getKey().longValue();
        return new TrainingLog(id, trainingLog.getPerformedAt(), trainingLog.getFinishedAt());
    }

    @Override
    public TrainingLog findById(Long id) {
        return jdbcTemplate.queryForObject("select id, performed_at, finished_at from training_log where id = :id",
                Map.of("id", id), (rs, rowNumber) ->
                        new TrainingLog(
                                rs.getLong("id"),
                                rs.getTimestamp("performed_at").toInstant(),
                                rs.getTimestamp("finished_at").toInstant()
                        ));
    }
}
