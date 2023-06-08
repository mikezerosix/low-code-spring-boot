#!/bin/bash
# Runs the Spring boot with grn-dll profile to make Hibernate generate the DDL and runs the sql parsing script

SQL_LOG=target/log/application-sql.log
rm ${SQL_LOG}
mvn compile && mvn spring-boot:start -P ddl-gen && src/scripts/generate-schema.sh && mvn spring-boot:stop