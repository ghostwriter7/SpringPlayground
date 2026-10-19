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
* cause is `SQLException`
* inspect error code and SQL state
* mapping of error codes to exceptions can be customized via a config file or by implementing `SQLExceptionTranslator`

## Comparison of concepts between JDBC, Hibernate and JPA

| Concept          | JDBC         | Hibernate          | JPA                  |
|------------------|--------------|--------------------|----------------------|
| Resource         | Connection   | Session            | EntityManager        |
| Resource Factory | DataSource   | SessionFactory     | EntityManagerFactory |
| Exception        | SQLException | HibernateException | PersistenceException |
