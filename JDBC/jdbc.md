# Java Database Connectivity (JDBC)

## Interactions

* `JdbcTemplate`
* `NamedParameterJdbcTemplate`

## `PreparedStatementCreator`

* given `Connection`, create `PreparedStatement` and bind parameters

## `PreparedStatementSetter`

* only binds parameters

## `BatchPreparedStatementSetter` 

* binds parameters for multiple `PreparedStatement`s

## `GeneratedKeyHolder`

* holds generated keys from `batchUpdate` or simple inserts 

## `BeanPropertyRowMapper`

* maps `ResultSet` to Java object using reflection

## `SqlParameterSource`

* `MapSqlParameterSource` - wrapper over a `Map`
* `BeanPropertySqlParameterSource` - wrapper over a Java object for mapping parameters

## Exception Handling

* `DataAccessException`