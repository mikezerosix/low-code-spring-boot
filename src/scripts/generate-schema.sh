#!/bin/bash
# Runs the Spring Boot  Parses the SQL_LOG

echo "******** Parsing SQL log *************"
SQL_LOG=target/log/application-sql.log
SQL_CREATE_TABLES=src/main/resources/db/h2/generated/create_tables.sql
SQL_CREATE_SEQ=src/main/resources/db/h2/generated/create_sequences.sql
SQL_DROP_CREATE_CONSTRAINTS=src/main/resources/db/h2/generated/drop_create_index_constraint.sql

if [ ! -e "${SQL_LOG}" ]; then
  echo "ERROR: ${SQL_LOG} does not exist !"
  exit 1
fi

perl -ne 'print if /create table/../\);/' ${SQL_LOG} > ${SQL_CREATE_TABLES}
sed -i 's/    create table/CREATE TABLE/' ${SQL_CREATE_TABLES}

grep "create sequence" ${SQL_LOG} > ${SQL_CREATE_SEQ}
perl -ne 'print if /create index/../;/' ${SQL_LOG} > ${SQL_DROP_CREATE_CONSTRAINTS}
sed -i 's/create index/CREATE INDEX/' ${SQL_DROP_CREATE_CONSTRAINTS}

echo "" >> ${SQL_DROP_CREATE_CONSTRAINTS}
perl -ne 'print if /alter table/../;/' ${SQL_LOG} >> ${SQL_DROP_CREATE_CONSTRAINTS}
sed -i 's/    alter table/ALTER TABLE/' ${SQL_DROP_CREATE_CONSTRAINTS}

echo "Buh-bye !"