# Java Database Connectivity (JDBC)

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